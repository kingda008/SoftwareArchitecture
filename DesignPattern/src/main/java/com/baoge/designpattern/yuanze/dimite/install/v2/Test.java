package com.baoge.designpattern.yuanze.dimite.install.v2;

public class Test {
    public static void main(String[] args) {
        InstallSoftware invoke = new InstallSoftware();
        invoke.installWizard(new Wizard());
    }
}
