// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: greeting.proto

package taotao.grpc;

public final class Greeting {
  private Greeting() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Greeting_Message_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Greeting_Message_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Greeting_Reply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Greeting_Reply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016greeting.proto\022\010Greeting\"\027\n\007Message\022\014\n" +
      "\004text\030\001 \001(\t\"\030\n\005Reply\022\017\n\007message\030\001 \001(\t26\n" +
      "\007Greeter\022+\n\003get\022\021.Greeting.Message\032\017.Gre" +
      "eting.Reply\"\000B\031\n\013taotao.grpcB\010GreetingP\001" +
      "b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Greeting_Message_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Greeting_Message_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Greeting_Message_descriptor,
        new java.lang.String[] { "Text", });
    internal_static_Greeting_Reply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Greeting_Reply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Greeting_Reply_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
