package ca.airspeed.qbdapi;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packages = "ca.airspeed.qbdapi", importOptions = { DoNotIncludeTests.class })
class ArchitectureTest {

    @ArchTest
    static final ArchRule hexagonal_architecture_is_respected = onionArchitecture()
        .domainModels("..domain..")
        .domainServices("..application.service..", "..application.port..")
        .applicationServices("..")
        .adapter("persistence", "..adapter.out.persistence..")
        .adapter("web", "..adapter.in.web..");
}
