package ca.airspeed.qbdapi.adapter.out.persistence;

import javax.inject.Singleton;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import io.micronaut.context.annotation.Replaces;
import io.micronaut.data.hibernate.naming.DefaultPhysicalNamingStrategy;
import io.micronaut.data.model.naming.NamingStrategies;
import io.micronaut.data.model.naming.NamingStrategy;

@Singleton
@Replaces(DefaultPhysicalNamingStrategy.class)
public class RawPhysicalNamingStrategy implements PhysicalNamingStrategy {

    NamingStrategy RAW = new NamingStrategies.Raw();

    @Override
    public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return getIdentifier(name);
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return getIdentifier(name);
    }

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return getIdentifier(name);
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return getIdentifier(name);
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return getIdentifier(name);
    }

    private Identifier getIdentifier(Identifier name) {
        if (name == null) {
            return null;
        }
        return new Identifier(
                RAW.mappedName(name.getText()),
                name.isQuoted()
        );
    }
}
