package concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executor;

/**
 * SampleExecutor
 * Learning
 *
 * @author WissenSolutions.
 */
public class NewThreadExecutor implements Executor {
    private static final Logger logger = LoggerFactory.getLogger(NewThreadExecutor.class);

    /**
     * Executes the given command at some time in the future.  The command
     * may execute in a new thread, in a pooled thread, or in the calling
     * thread, at the discretion of the {@code Executor} implementation.
     *
     * @param iRunnable the runnable task
     * @throws java.util.concurrent.RejectedExecutionException if this task cannot be
     *                                    accepted for execution
     * @throws NullPointerException       if command is null
     */
    @Override
    public void execute(Runnable iRunnable) {
        new Thread(iRunnable).start();
    }
}
