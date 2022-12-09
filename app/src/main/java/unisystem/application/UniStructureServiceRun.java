package unisystem.application;

import unisystem.view.View;
import unisystem.service.MajorService;

public interface UniStructureServiceRun {
    void runUniStructureService(MajorService majorService, View view, boolean adminPermission);
}