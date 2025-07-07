package skool.saas.skool.B_COLLEGE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skool.saas.skool.B_COLLEGE.Entity.TitulaireCollege;

@Repository
public interface TitulaireRepositoryCollege extends JpaRepository<TitulaireCollege, Long> {
}
