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
public class SampleRunnableExecutor implements Executor {
    private static final Logger logger = LoggerFactory.getLogger(SampleRunnableExecutor.class);

    /**
     * Executes the given command at some time in the future.  The command
     * may execute in a new thread, in a pooled thread, or in the calling
     * thread, at the discretion of the {@code Executor} implementation.
     *
     * @param command the runnable task
     * @throws RejectedExecutionException if this task cannot be
     *                                    accepted for execution
     * @throws NullPointerException       if command is null
     */
    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
