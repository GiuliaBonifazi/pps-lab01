package tdd;

import java.util.Optional;

public class SimpleSmartDoorLock implements SmartDoorLock {
    private static final int EMPTY_PIN = -1;
    private static final int MAX_ATTEMPTS = 3;
    private int pin = EMPTY_PIN;
    private int failedAttempts = 0;
    private boolean locked = false;
    private boolean blocked = false;

    @Override
    public void setPin(int pin) {
        if (!locked) {
            this.pin = pin;
        }
    }

    @Override
    public void unlock(int pin) {
        if (this.pin == EMPTY_PIN) {
            throw new IllegalStateException();
        }
        if (!blocked && locked) {
            if (this.pin == pin) {
                this.locked = false;
            } else {
                this.failedAttempts = this.failedAttempts + 1;
                if (this.failedAttempts >= MAX_ATTEMPTS) {
                    this.blocked = true;
                }
            }
        }
    }

    @Override
    public void lock() {
        if (this.pin == EMPTY_PIN) {
            throw new IllegalStateException();
        }
        this.locked = true;
    }

    @Override
    public boolean isLocked() {
        return this.locked;
    }

    @Override
    public boolean isBlocked() {
        return blocked;
    }

    @Override
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts() {
        return this.failedAttempts;
    }

    @Override
    public void reset() {

    }
}
