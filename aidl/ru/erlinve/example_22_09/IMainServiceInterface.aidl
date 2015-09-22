package ru.erlinve.example_22_09;

import ru.erlinve.example_22_09.IMainServiceCallback;

/**
 * Created by sebastian on 9/22/15.
 */
interface IMainServiceInterface {

    void registerServiceCallback(in IMainServiceCallback serviceCallback);
    void runNewThread();
}
