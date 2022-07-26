package bd.gov.banbeis.erp.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("bd.gov.banbeis.erp.repositories")
@EnableJpaAuditing //(auditorAwareRef = "springSecurityAuditAware")
@EnableTransactionManagement
public class DatabaseConfiguration {
}
