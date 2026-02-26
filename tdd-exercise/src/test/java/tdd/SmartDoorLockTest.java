package tdd;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    private static final int PIN_WRONG = 1234;
    private static final int PIN_RIGHT = 4567;
    private SmartDoorLock smartDoorLock;

    @BeforeEach
    void beforeEach() {
        smartDoorLock = new SimpleSmartDoorLock();
    }

    private void setPinAndLock(SmartDoorLock doorLock) {
        doorLock.setPin(PIN_RIGHT);
        doorLock.lock();
    }

    @Test
    void testPinIsEmptyOnCreation() {
        assertThrows(IllegalStateException.class, () -> smartDoorLock.unlock(PIN_WRONG));
    }

    @Test
    void testDoorIsOpenOnCreation() {
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    void testZeroFailedAttemptsOnCreation() {
        assertEquals(0, smartDoorLock.getFailedAttempts());
    }

    @Test
    void testLockEmptyPin() {
        assertThrows(IllegalStateException.class, () -> smartDoorLock.lock());
    }

    @Test
    void testLockWithPin() {
        setPinAndLock(smartDoorLock);
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    void testSetPin() {
        setPinAndLock(smartDoorLock);
        smartDoorLock.unlock(PIN_RIGHT);
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    void testSetPinDoorLocked() {
        setPinAndLock(smartDoorLock);
        smartDoorLock.setPin(PIN_WRONG);
        smartDoorLock.unlock(PIN_WRONG);
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    void testIncrementAttemptsOnWrongPin() {
        setPinAndLock(smartDoorLock);
        smartDoorLock.unlock(PIN_WRONG);
        assertEquals(1, smartDoorLock.getFailedAttempts());
    }
}
