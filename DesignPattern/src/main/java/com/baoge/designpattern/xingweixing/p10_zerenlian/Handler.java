package com.baoge.designpattern.xingweixing.p10_zerenlian;

public abstract class Handler {
    private Handler nextHandler;

    public final Response handleMessage(Request request) {
        Response response = null;
        if (this.getHandlerLevel().equals(request.getRequestLevel())) {
            response = this.echo(request);
        } else {
            if (this.nextHandler != null) {
                response = this.nextHandler.handleMessage(request);
            } else {

            }
        }
        return response;
    }

    public void setNext(Handler handler) {
        nextHandler = handler;
    }
    protected abstract Level getHandlerLevel();
    protected abstract Response echo(Request request);
}
