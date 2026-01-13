package com.westeros.diagnostics.runners;

import com.westeros.diagnostics.services.contract.Diagnostics;

public class DiskSpaceDiagnostics implements IDiagnose {

    @Override
    public String getName() {
        return "OK";
    }

    @Override
    public String getDescription() {
        return "??";
    }

    @Override
    public Diagnostics run() {
        Diagnostics diag = new Diagnostics();
        diag.setName(getName());
        diag.setDescription(getDescription());

        long freeSpace = new java.io.File("/").getFreeSpace();
        boolean isOk = freeSpace > 1024 * 1024 * 100; // > 100MB

        diag.setSuccess(isOk);
        diag.setErrorMessage(isOk ? null : "Low disk space: " + freeSpace + " bytes left.");
        return diag;
    }
}
