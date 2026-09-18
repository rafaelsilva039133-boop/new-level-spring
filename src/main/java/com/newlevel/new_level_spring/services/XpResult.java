package com.newlevel.new_level_spring.services;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class XpResult {
    private final boolean leveledUp;
    private final int newLevel;
    private final int levelsGained;
}