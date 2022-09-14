package com.baoge.designpattern.yuanze.dimite.install.v1;

public class Test {
    public static void main(String[] args) {
        InstallSoftware invoke = new InstallSoftware();
        invoke.installWizard(new Wizard());
    }
}
