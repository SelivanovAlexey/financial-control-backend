package app.core.repository;

import app.core.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с сущностью Income в базе данных.
 * <p>
 * Предоставляет стандартные CRUD-операции через {@link JpaRepository},
 * а также возможность добавления собственных запросов
 */
@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

}