package ca.airspeed.qbdapi.adapter.out.persistence;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ca.airspeed.qbdapi.domain.ServiceItem;

@ExtendWith(MockitoExtension.class)
class ItemServicePersistenceAdapterUnitTest {

    @Mock
    private ItemServiceMapper mockMapper;

    @Mock
    private ItemServiceJpaRepository mockRepo;

    @InjectMocks
    private ItemServicePersistenceAdapter adapter;

    @Test
    void findById() throws Exception {
        // Given:
        when(mockRepo.findById(isA(String.class))).thenReturn(Optional.of(new ItemServiceJpaEntity()));
        when(mockMapper.mapToDomainEntity(isA(Optional.class))).thenReturn(ServiceItem.builder().build());

        // When:
        ServiceItem result = adapter.findByServiceItemId("ABC-123");

        // Then:
        assertThat(result, notNullValue());
    }

    @Test
    void testFindByFullName() throws Exception {
        // Given:
        when(mockRepo.findByFullNameStartsWith(isA(String.class))).thenReturn(asList(new ItemServiceJpaEntity()));
        when(mockMapper.mapToDomainList(isA(List.class))).thenReturn(asList(ServiceItem.builder().build()));

        // When:
        List<ServiceItem> results = adapter.findByFullName("Software Development:SD100");

        // Then:
        assertThat(results, hasSize(1));
    }
}
