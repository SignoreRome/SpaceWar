package MainGame.Planets;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class Locker {
    public static final Lock lockerEarth = new ReentrantLock();
    public static final Lock lockerOrbit = new ReentrantLock();
    public static final Lock lockerMars = new ReentrantLock();
}
