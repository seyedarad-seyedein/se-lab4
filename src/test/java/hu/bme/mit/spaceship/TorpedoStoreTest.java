
package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        TorpedoStore store = new TorpedoStore(1, 0.0);

        assertTrue(store.fire(1));
        assertEquals(0, store.getTorpedoCount());
        assertTrue(store.isEmpty());
    }

    @Test
    void fire_Failure() {
        TorpedoStore store = new TorpedoStore(1, 1.0);

        assertFalse(store.fire(1));
        assertEquals(1, store.getTorpedoCount());
        assertFalse(store.isEmpty());
    }

    @Test
    void fire_ZeroTorpedoes_ThrowsException() {
        TorpedoStore store = new TorpedoStore(1);

        assertThrows(IllegalArgumentException.class,
                () -> store.fire(0));
    }

    @Test
    void fire_MoreTorpedoesThanAvailable_ThrowsException() {
        TorpedoStore store = new TorpedoStore(1);

        assertThrows(IllegalArgumentException.class,
                () -> store.fire(2));
    }
}
