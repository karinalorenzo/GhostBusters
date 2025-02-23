package dev.lidia.karina.ghost_buster.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ContainerTest {
    private Container container;
    private Ghost ghost2;
    private Ghost ghost3;
    private List<Ghost> ghosts;

    @BeforeEach
    public void setUp() {
        ghosts = new ArrayList<>();
        container = new Container();
        ghost2 = new Ghost(2, "Fantasma1", "TipoA", "Nivel1", "2025-01-01", "Habilidad1", "Afinidad1");
        ghost3 = new Ghost(3, "Fantasma2", "TipoB", "Nivel2", "2025-01-02", "Habilidad2", "Afinidad2");
    }

    @Test
    public void testAddGhost() {
        container.addGhost(ghost2);
        assertEquals(1, container.getGhosts().size());
    }

	@Test
    @DisplayName ("display list of ghosts captured")
	public void testGhostList() {
        Container container = new Container();
        container.addGhost(new Ghost(2, "Fantasma1", "TipoA", "Nivel1", "2025-01-01", "Habilidad1", "Afinidad1"));
        container.addGhost(new Ghost(3, "Fantasma2", "TipoB", "Nivel2", "2025-01-02", "Habilidad2", "Afinidad2"));
        container.ghostList(); 
        
	}

    @Test
    @DisplayName ("release ghost from ghost captured list")
    void testRemoveGhost() {
        container.addGhost(ghost2);
        container.removeGhost(2);
        assertEquals(0, container.getGhosts().size());
    }

    @Test
    @DisplayName ("display list by ghost type")
    void testFilterByType() {
        container.addGhost(ghost2);
        container.addGhost(ghost3);
        List<Ghost> filtered = container.filterByType("TipoA");
        assertEquals(1, filtered.size());
        assertEquals("Fantasma1", filtered.get(0).getName());
    }

    @Test
    @DisplayName ("display list by ghost month captured")
    void testFilterByMonth() {
        Container container = new Container();
        container.addGhost(new Ghost(1, "Fantasma1", "TipoA", "Nivel1", "2025-01-01", "Habilidad1", "Afinidad1"));
        container.addGhost(new Ghost(2, "Fantasma2", "TipoB", "Nivel2", "2025-01-15", "Habilidad2", "Afinidad2"));
        container.addGhost(new Ghost(3, "Fantasma3", "TipoC", "Nivel3", "2025-02-01", "Habilidad3", "Afinidad3"));
        

        List<Ghost> enero = container.filterByMonth("01");
        assertEquals(2, enero.size());
        assertTrue(enero.stream().allMatch(ghost -> ghost.getDate().startsWith("2025-01")));
        assertFalse(enero.contains(container.getGhosts().get(2)));
        }
    }
    
