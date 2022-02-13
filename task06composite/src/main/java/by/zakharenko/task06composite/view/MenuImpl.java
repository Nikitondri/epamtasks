package by.zakharenko.task06composite.view;

import by.zakharenko.task06composite.controller.Controller;
import by.zakharenko.task06composite.controller.ControllerImpl;

public class MenuImpl implements Menu{
    private final OutputData outputData = new OutputData();
    private final CreatorRequest creatorRequest = new CreatorRequestImpl();

    @Override
    public void openMenu() {
        Controller controller = new ControllerImpl();
        outputData.outputResult(controller.executeAction(creatorRequest.create()));
    }
}
