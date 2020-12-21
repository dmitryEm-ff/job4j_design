package ru.job4j.io;

import java.util.ArrayList;

public class Shell {

    private ArrayList pathDir = new ArrayList();

    public void cd(String path) {
        if (path.endsWith("..") || path == "/") {
            pathDir.removeAll(pathDir);
            pathDir.add("/");
        } else {
            pathDir.add("/" + path);
        }
    }

    public String pwd() {
        StringBuilder pathFull = new StringBuilder();
        pathDir.forEach(pathFull::append);
        return pathFull.toString();
    }
}