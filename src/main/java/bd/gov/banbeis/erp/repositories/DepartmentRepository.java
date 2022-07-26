package bd.gov.banbeis.erp.repositories;

import bd.gov.banbeis.erp.domains.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "department")
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
