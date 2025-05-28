package app.core.service;

import app.core.api.IncomeService;
import app.core.model.Income;
import app.core.repository.IncomeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

/**
 * Реализация сервис доходов.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;

    @Override
    public Income get(Long id) {
        return incomeRepository
                .findById(id).orElseThrow(() -> new EntityNotFoundException("Не найдено дохода по id: " + id));
    }

    @Override
    public Income create(Income income) {
        income.setCreateDate(OffsetDateTime.now());
        return incomeRepository.save(income);
    }

    @Override
    public Income delete(Long id) {
        Income income = incomeRepository
                .findById(id).orElseThrow(() -> new EntityNotFoundException("Не найдено дохода по id: " + id));
        incomeRepository.delete(income);
        return income;
    }

    @Override
    public Income update(Long id, Income newIncome) {
        newIncome.setId(id);
        newIncome.setCreateDate(OffsetDateTime.now());
        return incomeRepository.saveAndFlush(newIncome);
    }
}
