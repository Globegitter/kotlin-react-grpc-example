// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: helloworld.proto

package io.grpc.examples.helloworld;

/**
 * <pre>
 * The request message containing the user's name.
 * </pre>
 *
 * Protobuf type {@code helloworld.HelloRequest}
 */
public  final class HelloRequest extends
    com.google.protobuf.GeneratedMessageLite<
        HelloRequest, HelloRequest.Builder> implements
    // @@protoc_insertion_point(message_implements:helloworld.HelloRequest)
    HelloRequestOrBuilder {
  private HelloRequest() {
    name_ = "";
  }
  public static final int NAME_FIELD_NUMBER = 1;
  private java.lang.String name_;
  /**
   * <code>string name = 1;</code>
   */
  @java.lang.Override
  public java.lang.String getName() {
    return name_;
  }
  /**
   * <code>string name = 1;</code>
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getNameBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(name_);
  }
  /**
   * <code>string name = 1;</code>
   */
  private void setName(
      java.lang.String value) {
    if (value == null) {
    throw new NullPointerException();
  }
  
    name_ = value;
  }
  /**
   * <code>string name = 1;</code>
   */
  private void clearName() {
    
    name_ = getDefaultInstance().getName();
  }
  /**
   * <code>string name = 1;</code>
   */
  private void setNameBytes(
      com.google.protobuf.ByteString value) {
    if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
    
    name_ = value.toStringUtf8();
  }

  public static io.grpc.examples.helloworld.HelloRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static io.grpc.examples.helloworld.HelloRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static io.grpc.examples.helloworld.HelloRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static io.grpc.examples.helloworld.HelloRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static io.grpc.examples.helloworld.HelloRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static io.grpc.examples.helloworld.HelloRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static io.grpc.examples.helloworld.HelloRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static io.grpc.examples.helloworld.HelloRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static io.grpc.examples.helloworld.HelloRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static io.grpc.examples.helloworld.HelloRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static io.grpc.examples.helloworld.HelloRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static io.grpc.examples.helloworld.HelloRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return (Builder) DEFAULT_INSTANCE.createBuilder();
  }
  public static Builder newBuilder(io.grpc.examples.helloworld.HelloRequest prototype) {
    return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
  }

  /**
   * <pre>
   * The request message containing the user's name.
   * </pre>
   *
   * Protobuf type {@code helloworld.HelloRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        io.grpc.examples.helloworld.HelloRequest, Builder> implements
      // @@protoc_insertion_point(builder_implements:helloworld.HelloRequest)
      io.grpc.examples.helloworld.HelloRequestOrBuilder {
    // Construct using io.grpc.examples.helloworld.HelloRequest.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>string name = 1;</code>
     */
    @java.lang.Override
    public java.lang.String getName() {
      return instance.getName();
    }
    /**
     * <code>string name = 1;</code>
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getNameBytes() {
      return instance.getNameBytes();
    }
    /**
     * <code>string name = 1;</code>
     */
    public Builder setName(
        java.lang.String value) {
      copyOnWrite();
      instance.setName(value);
      return this;
    }
    /**
     * <code>string name = 1;</code>
     */
    public Builder clearName() {
      copyOnWrite();
      instance.clearName();
      return this;
    }
    /**
     * <code>string name = 1;</code>
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setNameBytes(value);
      return this;
    }

    // @@protoc_insertion_point(builder_scope:helloworld.HelloRequest)
  }
  @java.lang.Override
  @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
  protected final java.lang.Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      java.lang.Object arg0, java.lang.Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new io.grpc.examples.helloworld.HelloRequest();
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case BUILD_MESSAGE_INFO: {
          java.lang.Object[] objects = new java.lang.Object[] {
            "name_",
          };
          java.lang.String info =
              "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0208";
          return newMessageInfo(DEFAULT_INSTANCE, info, objects);
      }
      // fall through
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        com.google.protobuf.Parser<io.grpc.examples.helloworld.HelloRequest> parser = PARSER;
        if (parser == null) {
          synchronized (io.grpc.examples.helloworld.HelloRequest.class) {
            parser = PARSER;
            if (parser == null) {
              parser = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
              PARSER = parser;
            }
          }
        }
        return parser;
    }
    case GET_MEMOIZED_IS_INITIALIZED: {
      return (byte) 1;
    }
    case SET_MEMOIZED_IS_INITIALIZED: {
      return null;
    }
    }
    throw new UnsupportedOperationException();
  }


  // @@protoc_insertion_point(class_scope:helloworld.HelloRequest)
  private static final io.grpc.examples.helloworld.HelloRequest DEFAULT_INSTANCE;
  static {
    // New instances are implicitly immutable so no need to make
    // immutable.
    DEFAULT_INSTANCE = new HelloRequest();
  }

  static {
    com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
      HelloRequest.class, DEFAULT_INSTANCE);
  }
  public static io.grpc.examples.helloworld.HelloRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<HelloRequest> PARSER;

  public static com.google.protobuf.Parser<HelloRequest> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

