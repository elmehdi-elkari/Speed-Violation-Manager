package ma.enset.stub;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: radar.proto")
public final class sendInfractionGrpc {

  private sendInfractionGrpc() {}

  public static final String SERVICE_NAME = "sendInfraction";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ma.enset.stub.Radar.Empty,
      ma.enset.stub.Radar.infractionInfo> getSendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "send",
      requestType = ma.enset.stub.Radar.Empty.class,
      responseType = ma.enset.stub.Radar.infractionInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ma.enset.stub.Radar.Empty,
      ma.enset.stub.Radar.infractionInfo> getSendMethod() {
    io.grpc.MethodDescriptor<ma.enset.stub.Radar.Empty, ma.enset.stub.Radar.infractionInfo> getSendMethod;
    if ((getSendMethod = sendInfractionGrpc.getSendMethod) == null) {
      synchronized (sendInfractionGrpc.class) {
        if ((getSendMethod = sendInfractionGrpc.getSendMethod) == null) {
          sendInfractionGrpc.getSendMethod = getSendMethod = 
              io.grpc.MethodDescriptor.<ma.enset.stub.Radar.Empty, ma.enset.stub.Radar.infractionInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "sendInfraction", "send"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ma.enset.stub.Radar.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ma.enset.stub.Radar.infractionInfo.getDefaultInstance()))
                  .setSchemaDescriptor(new sendInfractionMethodDescriptorSupplier("send"))
                  .build();
          }
        }
     }
     return getSendMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static sendInfractionStub newStub(io.grpc.Channel channel) {
    return new sendInfractionStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static sendInfractionBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new sendInfractionBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static sendInfractionFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new sendInfractionFutureStub(channel);
  }

  /**
   */
  public static abstract class sendInfractionImplBase implements io.grpc.BindableService {

    /**
     */
    public void send(ma.enset.stub.Radar.Empty request,
        io.grpc.stub.StreamObserver<ma.enset.stub.Radar.infractionInfo> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ma.enset.stub.Radar.Empty,
                ma.enset.stub.Radar.infractionInfo>(
                  this, METHODID_SEND)))
          .build();
    }
  }

  /**
   */
  public static final class sendInfractionStub extends io.grpc.stub.AbstractStub<sendInfractionStub> {
    private sendInfractionStub(io.grpc.Channel channel) {
      super(channel);
    }

    private sendInfractionStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected sendInfractionStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new sendInfractionStub(channel, callOptions);
    }

    /**
     */
    public void send(ma.enset.stub.Radar.Empty request,
        io.grpc.stub.StreamObserver<ma.enset.stub.Radar.infractionInfo> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSendMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class sendInfractionBlockingStub extends io.grpc.stub.AbstractStub<sendInfractionBlockingStub> {
    private sendInfractionBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private sendInfractionBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected sendInfractionBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new sendInfractionBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<ma.enset.stub.Radar.infractionInfo> send(
        ma.enset.stub.Radar.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getSendMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class sendInfractionFutureStub extends io.grpc.stub.AbstractStub<sendInfractionFutureStub> {
    private sendInfractionFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private sendInfractionFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected sendInfractionFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new sendInfractionFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SEND = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final sendInfractionImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(sendInfractionImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND:
          serviceImpl.send((ma.enset.stub.Radar.Empty) request,
              (io.grpc.stub.StreamObserver<ma.enset.stub.Radar.infractionInfo>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class sendInfractionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    sendInfractionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ma.enset.stub.Radar.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("sendInfraction");
    }
  }

  private static final class sendInfractionFileDescriptorSupplier
      extends sendInfractionBaseDescriptorSupplier {
    sendInfractionFileDescriptorSupplier() {}
  }

  private static final class sendInfractionMethodDescriptorSupplier
      extends sendInfractionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    sendInfractionMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (sendInfractionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new sendInfractionFileDescriptorSupplier())
              .addMethod(getSendMethod())
              .build();
        }
      }
    }
    return result;
  }
}
