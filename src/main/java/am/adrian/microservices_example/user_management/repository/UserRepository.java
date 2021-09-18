package am.adrian.microservices_example.user_management.repository;

import am.adrian.microservices_example.user_management.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import th.co.geniustree.springdata.jpa.repository.JpaSpecificationExecutorWithProjection;

public interface UserRepository extends PagingAndSortingRepository<User, Long>,
    JpaSpecificationExecutorWithProjection<User> {
}