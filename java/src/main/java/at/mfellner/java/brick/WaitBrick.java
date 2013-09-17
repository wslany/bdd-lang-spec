/*
 * Copyright 2013 Maximilian Fellner
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package at.mfellner.java.brick;

public class WaitBrick extends Brick {
    private final Object mLock;
    private long mTime;

    public WaitBrick(long millis) {
        mLock = new Object();
        mTime = millis;
    }

    @Override
    public Runnable getRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (mLock) {
                        mLock.wait(mTime);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}