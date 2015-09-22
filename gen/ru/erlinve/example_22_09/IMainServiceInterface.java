/*___Generated_by_IDEA___*/

/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/sebastian/Projects/example_22_09/aidl/ru/erlinve/example_22_09/IMainServiceInterface.aidl
 */
package ru.erlinve.example_22_09;
/**
 * Created by sebastian on 9/22/15.
 */
public interface IMainServiceInterface extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements ru.erlinve.example_22_09.IMainServiceInterface
{
private static final java.lang.String DESCRIPTOR = "ru.erlinve.example_22_09.IMainServiceInterface";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an ru.erlinve.example_22_09.IMainServiceInterface interface,
 * generating a proxy if needed.
 */
public static ru.erlinve.example_22_09.IMainServiceInterface asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof ru.erlinve.example_22_09.IMainServiceInterface))) {
return ((ru.erlinve.example_22_09.IMainServiceInterface)iin);
}
return new ru.erlinve.example_22_09.IMainServiceInterface.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_registerServiceCallback:
{
data.enforceInterface(DESCRIPTOR);
ru.erlinve.example_22_09.IMainServiceCallback _arg0;
_arg0 = ru.erlinve.example_22_09.IMainServiceCallback.Stub.asInterface(data.readStrongBinder());
this.registerServiceCallback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_runNewThread:
{
data.enforceInterface(DESCRIPTOR);
this.runNewThread();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements ru.erlinve.example_22_09.IMainServiceInterface
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void registerServiceCallback(ru.erlinve.example_22_09.IMainServiceCallback serviceCallback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((serviceCallback!=null))?(serviceCallback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerServiceCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void runNewThread() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_runNewThread, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_registerServiceCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_runNewThread = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
public void registerServiceCallback(ru.erlinve.example_22_09.IMainServiceCallback serviceCallback) throws android.os.RemoteException;
public void runNewThread() throws android.os.RemoteException;
}
