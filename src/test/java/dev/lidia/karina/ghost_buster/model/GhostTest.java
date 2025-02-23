package dev.lidia.karina.ghost_buster.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GhostTest {

    private Ghost ghost1;
    private List<Ghost> ghosts;

    @BeforeEach
    void setUp() {
        ghosts = new ArrayList<>();
        ghost1 = new Ghost(1, "Casper", "Friendly", "Low", "2023-10-01", "Invisibility", "7/10");
        ghosts.add(ghost1);
    }

    @Test
    @DisplayName("Test Ghost ID")
    void testGhostId() {
        assertEquals(ghost1.getId(), ghosts.get(0).getId());
    }

    @Test
    @DisplayName("Test name of class ghost")
    void testGetName() {
        assertEquals("Casper", ghosts.get(0).getName());
    }

    @Test
    @DisplayName("Test type of class ghost")
    void testGetType() {
        assertEquals("Friendly", ghosts.get(0).getType());
    }

    @Test
    @DisplayName("Test level of class ghost")
    void testGetLevel() {
        assertEquals("Low", ghosts.get(0).getLevel());
    }

    @Test
    @DisplayName("Test date of class ghost")
    void testGetDate() {
        assertEquals("2023-10-01", ghosts.get(0).getDate());

    }

    @Test
    @DisplayName("Test ability of class ghost")
    void testGetAbility() {
        assertEquals("Invisibility", ghosts.get(0).getAbility());
    }

    @Test
    @DisplayName("Test ability of class ghost")
    void testGetAfinity() {
        assertEquals("7/10", ghosts.get(0).getAfinity());

        
    }

}
