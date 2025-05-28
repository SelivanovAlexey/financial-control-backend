package app.core.api;

import app.core.model.Income;

/**
 * Сервис доходов.
 */
public interface IncomeService {

    /**
     * Получить доход по id.
     *
     * @param id идентификатор доход.
     * @return сущность дохода
     */
    Income get(Long id);


    /**
     * Добавить доход.
     *
     * @param medicine сущность дохода
     * @return доход
     */
    Income create(Income medicine);

    /**
     * Удалить доход по идентификатору.
     *
     * @param id идентификатор дохода
     * @return удаленное дохода
     */
    Income delete(Long id);

    /**
     * Обновить доход по идентификатору.
     *
     * @param id идентификатор дохода
     * @param medicine доход
     * @return обновленное дохода
     */
    Income update(Long id, Income medicine);
}
