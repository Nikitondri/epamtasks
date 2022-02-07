package by.zakharenko.task05multithreading.controller;

import by.zakharenko.task05multithreading.controller.command.CommandCallable;
import by.zakharenko.task05multithreading.entity.Data;
import by.zakharenko.task05multithreading.view.Menu;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * The {@code class} that receives data from the view layer
 * Passing data to a service layer to execute business logic and and event handling
 * @see CommandProvider
 * @see CommandCallable
 */
public final class ControllerImpl implements Controller {
    static final Logger LOGGER = LogManager.getLogger(ControllerImpl.class.getName());

    /**
     * Passing data to a service layer to execute business logic and and event handling
     * @see CommandProvider
     * @see CommandCallable
     * @param commandNameData user-selected command
     * @param requestData {@code HashMap} an object containing the textual result of execution or a thrown exception
     */
    @Override
    public Data<Map<Boolean, String>> executeTask(Data<String> commandNameData, Data<Data<String>> requestData) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Data<CommandCallable> commandCallableData = new Data<>();
        CommandProvider provider;
        for(int i = 0; i < Menu.REQUEST_NUMBER; i++) {
            provider = new CommandProvider(requestData.getElement(i));
            commandCallableData.put(provider.getCommand(commandNameData.getElement(i)));
        }
        Data<Future<HashMap<Boolean, String>>> futures = new Data<>();
        try {
            futures = new Data<>(executorService.invokeAll(commandCallableData.getList()));
        } catch (InterruptedException e) {
            LOGGER.log(Level.WARN, "Interrupted!", e);
            Thread.currentThread().interrupt();
        }
        Data<Map<Boolean, String>> responseData = new Data<>();
        for(Future<HashMap<Boolean, String>> future: futures.getList()) {
            try {
                responseData.put(future.get());
            } catch (InterruptedException e) {
                LOGGER.log(Level.WARN, "Interrupted!", e);
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                Map<Boolean, String> result = new HashMap<>();
                result.put(false, e.toString());
                responseData.put(result);
            }
        }
        executorService.shutdown();
        return responseData;
    }
}
