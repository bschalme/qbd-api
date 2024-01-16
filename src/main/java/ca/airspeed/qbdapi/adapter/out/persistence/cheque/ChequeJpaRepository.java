package ca.airspeed.qbdapi.adapter.out.persistence.cheque;

import static java.lang.String.format;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import ca.airspeed.qbdapi.domain.DividendYear;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.GenericRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public abstract class ChequeJpaRepository implements GenericRepository<DividendYear, String> {

    private final EntityManager entityManager;

    private static final String STATEMENT_SQLMAP = "Statement-SQL-Mapping";

    @SuppressWarnings("unchecked")
    @Transactional
    public List<DividendYear> getHistoricalDividendSummary(Integer month, Integer day){
        String sql = format("SELECT YEAR(c.txnDate) AS Year, \n"
                + "ROUND(SUM(d.Amount), 2) AS Amount\n"
                + "FROM %s.check c\n"
                + "INNER JOIN txnexpenselinedetail d ON c.txnID = d.idkey\n"
                + "WHERE d.accountRef_FullName = 'Dividends' \n"
                + "AND c.txnDate BETWEEN CONCAT(YEAR(c.txnDate), '-', LPAD(1, 2, '00'), '-', LPAD(1, 2, '00'))\n"
                + "  AND CONCAT(YEAR(c.txnDate), '-', LPAD(:month, 2, '00'), '-', LPAD(:day, 2, '00'))\n"
                + "GROUP BY Year\n"
                + "ORDER BY Year DESC", System.getenv("DB_NAME"));
        return entityManager.createNativeQuery(sql, STATEMENT_SQLMAP)
                .setParameter("month", month)
                .setParameter("day", day)
                .getResultList();
    }
}
