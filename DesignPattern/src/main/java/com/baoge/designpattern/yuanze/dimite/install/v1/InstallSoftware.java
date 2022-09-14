package com.baoge.designpattern.yuanze.dimite.install.v1;

public class InstallSoftware {
    public void installWizard(Wizard wizard) {
        int first = wizard.first();
        if (first > 50) {
            int second = wizard.second();
            if (second > 50) {
                wizard.third();
            }
        }
    }
}
