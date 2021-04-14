package ca.airspeed.qbdapi.adapter.out.persistence;

import static java.time.ZoneId.systemDefault;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ca.airspeed.qbdapi.domain.Account;
import ca.airspeed.qbdapi.domain.CreditCardCharge;
import ca.airspeed.qbdapi.domain.TxnExpenseLineDetail;
import ca.airspeed.qbdapi.domain.Vendor;

@ExtendWith(MockitoExtension.class)
class CreditCardChargePersistenceAdapterUnitTest {

    @InjectMocks
    private CreditCardChargePersistenceAdapter adapter;

    @Mock
    private CreditCardChargeJpaRepository mockCreditCardChargeRepo;

    @Mock
    private TxnExpenseLineDetailJpaRepository mocklTxnExpenseLineDetailRepo;

    @Captor
    private ArgumentCaptor<CreditCardChargeJpaEntity> creditCardChargeCaptor;

    @Captor
    private ArgumentCaptor<Iterable<TxnExpenseLineDetailJpaEntity>> txnExpenseLineDetailCaptor;

    @Test
    void testAddCreditCardCharge() throws Exception {
        // Given:
        LocalDate today = LocalDate.now();
        CreditCardCharge charge = CreditCardCharge.builder()
                .account(Account.builder()
                        .id("3A1234-98756434")
                        .name("Pirate Express")
                        .build())
                .payee(Vendor.builder()
                        .id("8000E8-876543212")
                        .name("East India Company")
                        .build())
                .txnDate(today)
                .refNumber("3397845")
                .amount(BigDecimal.valueOf(1327, 2))
                .memo("Sail repair kit")
                .expenseLines(Set.of(TxnExpenseLineDetail.builder()
                        .account(Account.builder()
                                .id("8009E-12687532")
                                .fullName("Ship Supplies")
                                .build())
                        .amount(BigDecimal.valueOf(1327, 2))
                        .build()))
                .build();
        when(mockCreditCardChargeRepo.save(isA(CreditCardChargeJpaEntity.class))).thenReturn(newCreditCardChargeJpaEntity());

        // When:
        CreditCardCharge result = adapter.addCreditCardCharge(charge);

        // Then:
        verify(mockCreditCardChargeRepo).save(creditCardChargeCaptor.capture());
        CreditCardChargeJpaEntity creditCardChargeJpaEntity = creditCardChargeCaptor.getValue();
        assertThat(creditCardChargeJpaEntity, notNullValue());
        assertThat("CreditCardCharge TxnID;", creditCardChargeJpaEntity.getTxnID(), not(emptyOrNullString()));
        AccountJpaEntity accountJpaEntity = creditCardChargeJpaEntity.getAccount();
        assertThat("Account;", accountJpaEntity, notNullValue());
        assertThat("Account ListID;", accountJpaEntity.getListID(), is("3A1234-98756434"));
        VendorJpaEntity payeeJpaEntity = creditCardChargeJpaEntity.getPayee();
        assertThat("Payee;", payeeJpaEntity, notNullValue());
        assertThat("Payee ListID;", payeeJpaEntity.getListID(), is("8000E8-876543212"));
        Date expectedDate = Date.from(today.atStartOfDay(systemDefault()).toInstant());
        assertThat("TxnDate;", creditCardChargeJpaEntity.getTxnDate(), is(expectedDate));
        assertThat("Ref Number;", creditCardChargeJpaEntity.getRefNumber(), is("3397845"));
        assertThat("Total Amount;", creditCardChargeJpaEntity.getAmount(), is(BigDecimal.valueOf(1327, 2)));
        assertThat("Memo;", creditCardChargeJpaEntity.getMemo(), is("Sail repair kit"));
        assertThat("Status;", creditCardChargeJpaEntity.getStatus(), is("ADD"));

        verify(mocklTxnExpenseLineDetailRepo).saveAll(txnExpenseLineDetailCaptor.capture());
        Set<TxnExpenseLineDetailJpaEntity> expenseLinesJpaEntities = (Set<TxnExpenseLineDetailJpaEntity>) txnExpenseLineDetailCaptor.getValue();
        assertThat("Expense Lines;", expenseLinesJpaEntities, hasSize(1));
        TxnExpenseLineDetailJpaEntity expenseLineJpaEntity = expenseLinesJpaEntities.iterator().next();
        assertThat("Expense Line ID;", expenseLineJpaEntity.getTxnLineID(), not(emptyOrNullString()));
        AccountJpaEntity expenseAccountJpaEntity = expenseLineJpaEntity.getAccount();
        assertThat("Expense Account;", expenseAccountJpaEntity, notNullValue());
        assertThat("Expense Account ListID;", expenseAccountJpaEntity.getListID(), is("8009E-12687532"));
        assertThat("Expense Account FullName;", expenseAccountJpaEntity.getFullName(), is("Ship Supplies"));
        assertThat("Expense line amount;", expenseLineJpaEntity.getAmount(), is(BigDecimal.valueOf(1327, 2)));
        assertThat("Expense line IDKEY;", expenseLineJpaEntity.getIdKey(), is(creditCardChargeJpaEntity.getTxnID()));

        assertThat(result, notNullValue());
    }

    private CreditCardChargeJpaEntity newCreditCardChargeJpaEntity() {
        CreditCardChargeJpaEntity result = new CreditCardChargeJpaEntity();
        result.setTxnID("ABC-123");
        result.setTxnDate(Date.from(LocalDate.now().atStartOfDay(systemDefault()).toInstant()));
        return result;
    }
}
