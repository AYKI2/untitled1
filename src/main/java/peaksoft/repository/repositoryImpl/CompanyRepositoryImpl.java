package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.model.Company;
import peaksoft.repository.CompanyRepository;

import java.util.List;
@Repository
@Transactional
public class CompanyRepositoryImpl implements CompanyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Company company) {
        entityManager.persist(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return entityManager.createQuery("SELECT c FROM Company c", Company.class).getResultList();
    }

    @Override
    public Company getCompanyById(Long id) {
        return null;
    }

    @Override
    public void deleteCompany(Long id) {
        entityManager.remove(entityManager.find(Company.class,id));
    }

    @Override
    public void updateCompany(Long id, Company updatedCompany) {
        Company company = entityManager.find(Company.class, id);
        company.setId(company.getId());
        if(updatedCompany.getName().isEmpty()) company.setName(company.getName());
        else company.setName(updatedCompany.getName());

        if(updatedCompany.getCountry().isEmpty()) company.setCountry(company.getCountry());
        else company.setCountry(updatedCompany.getName());

        if(company.getImage().isEmpty()) company.setImage(company.getImage());
        else company.setName(updatedCompany.getName());
    }
}
