package ru.hh.school.example.impl;

import ru.hh.school.example.Recommendation;
import ru.hh.school.example.RecommendationRepository;
import org.springframework.stereotype.Component;

@Component
public class MemRecommendationRepository extends MemRepository<Recommendation> implements
              RecommendationRepository {
}
