package com.newlevel.new_level_spring.services;


import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.newlevel.new_level_spring.model.User;
import com.newlevel.new_level_spring.types.Difficulty;

@Service
@RequiredArgsConstructor
public class XpService {

    private static final int XP_EASY = 10;
    private static final int XP_MEDIUM = 20;
    private static final int XP_HARD = 40;

    public XpResult addXpForTaskCompletion(User user, Difficulty difficulty) {
      int xpGained = switch (difficulty) {
        case EASY -> XP_EASY;
        case MEDIUM -> XP_MEDIUM;
        case HARD -> XP_HARD;
      };

      user.setCurrentXp(user.getCurrentXp() + xpGained);
      return checkLevelUp(user);
    }

    private XpResult checkLevelUp(User user) {
      int levelsGained = 0;
      int xpToNextLevel = xpRequiredForLevel(user.getLevel() + 1);

      while (user.getCurrentXp() >= xpToNextLevel) {
        user.setCurrentXp(user.getCurrentXp() - xpToNextLevel);
        user.setLevel(user.getLevel() + 1);
        xpToNextLevel = xpRequiredForLevel(user.getLevel() + 1);
      }
      return new XpResult(levelsGained > 0, user.getLevel(), levelsGained);
    }

    private int xpRequiredForLevel(int level) {
      return level * 100; // fórmula simples, ajusta como quiser
    }
}