package tdd.lock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    private static final int PIN_WRONG = 1234;
    private static final int PIN_TOO_LONG = 12345;
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

    private void blockDoor(SmartDoorLock doorLock) {
        for (int i = 0; i < doorLock.getMaxAttempts(); i++) {
            doorLock.unlock(PIN_WRONG);
        }
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

    @Test
    void testNotBlockedOnCreation() {
        assertFalse(smartDoorLock.isBlocked());
    }

    @Test
    void testBlockedAfterMaxAttempts() {
        setPinAndLock(smartDoorLock);
        blockDoor(smartDoorLock);
        assertTrue(smartDoorLock.isBlocked());
    }

    @Test
    void testCannotOpenWhenBlocked() {
        setPinAndLock(smartDoorLock);
        blockDoor(smartDoorLock);
        smartDoorLock.unlock(PIN_RIGHT);
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    void testDoorUnlockedOnReset() {
        setPinAndLock(smartDoorLock);
        smartDoorLock.reset();
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    void testDoorNotBlockedOnReset() {
        setPinAndLock(smartDoorLock);
        blockDoor(smartDoorLock);
        smartDoorLock.reset();
        assertFalse(smartDoorLock.isBlocked());
    }

    @Test
    void testPinEmptyOnReset() {
        setPinAndLock(smartDoorLock);
        smartDoorLock.reset();
        assertThrows(IllegalStateException.class, () -> smartDoorLock.unlock(PIN_RIGHT));
    }

    @Test
    void testPinTooLong() {
        smartDoorLock.setPin(PIN_TOO_LONG);
        assertThrows(IllegalStateException.class, () -> smartDoorLock.lock());
    }
}
