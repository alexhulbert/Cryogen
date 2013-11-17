package com.alexhulbert.icewind;

public final class Protobuf {
  private Protobuf() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface DeviceUdidsOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required string psid = 1;
    /**
     * <code>required string psid = 1;</code>
     */
    boolean hasPsid();
    /**
     * <code>required string psid = 1;</code>
     */
    java.lang.String getPsid();
    /**
     * <code>required string psid = 1;</code>
     */
    com.google.protobuf.ByteString
        getPsidBytes();

    // repeated bytes udids = 2;
    /**
     * <code>repeated bytes udids = 2;</code>
     */
    java.util.List<com.google.protobuf.ByteString> getUdidsList();
    /**
     * <code>repeated bytes udids = 2;</code>
     */
    int getUdidsCount();
    /**
     * <code>repeated bytes udids = 2;</code>
     */
    com.google.protobuf.ByteString getUdids(int index);

    // optional bool usuallyFalse = 3;
    /**
     * <code>optional bool usuallyFalse = 3;</code>
     */
    boolean hasUsuallyFalse();
    /**
     * <code>optional bool usuallyFalse = 3;</code>
     */
    boolean getUsuallyFalse();
  }
  /**
   * Protobuf type {@code DeviceUdids}
   */
  public static final class DeviceUdids extends
      com.google.protobuf.GeneratedMessage
      implements DeviceUdidsOrBuilder {
    // Use DeviceUdids.newBuilder() to construct.
    private DeviceUdids(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private DeviceUdids(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final DeviceUdids defaultInstance;
    public static DeviceUdids getDefaultInstance() {
      return defaultInstance;
    }

    public DeviceUdids getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private DeviceUdids(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              bitField0_ |= 0x00000001;
              psid_ = input.readBytes();
              break;
            }
            case 18: {
              if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
                udids_ = new java.util.ArrayList<com.google.protobuf.ByteString>();
                mutable_bitField0_ |= 0x00000002;
              }
              udids_.add(input.readBytes());
              break;
            }
            case 24: {
              bitField0_ |= 0x00000002;
              usuallyFalse_ = input.readBool();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
          udids_ = java.util.Collections.unmodifiableList(udids_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Protobuf.internal_static_DeviceUdids_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Protobuf.internal_static_DeviceUdids_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Protobuf.DeviceUdids.class, Protobuf.DeviceUdids.Builder.class);
    }

    public static com.google.protobuf.Parser<DeviceUdids> PARSER =
        new com.google.protobuf.AbstractParser<DeviceUdids>() {
      public DeviceUdids parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new DeviceUdids(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<DeviceUdids> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required string psid = 1;
    public static final int PSID_FIELD_NUMBER = 1;
    private java.lang.Object psid_;
    /**
     * <code>required string psid = 1;</code>
     */
    public boolean hasPsid() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string psid = 1;</code>
     */
    public java.lang.String getPsid() {
      java.lang.Object ref = psid_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          psid_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string psid = 1;</code>
     */
    public com.google.protobuf.ByteString
        getPsidBytes() {
      java.lang.Object ref = psid_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        psid_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // repeated bytes udids = 2;
    public static final int UDIDS_FIELD_NUMBER = 2;
    private java.util.List<com.google.protobuf.ByteString> udids_;
    /**
     * <code>repeated bytes udids = 2;</code>
     */
    public java.util.List<com.google.protobuf.ByteString>
        getUdidsList() {
      return udids_;
    }
    /**
     * <code>repeated bytes udids = 2;</code>
     */
    public int getUdidsCount() {
      return udids_.size();
    }
    /**
     * <code>repeated bytes udids = 2;</code>
     */
    public com.google.protobuf.ByteString getUdids(int index) {
      return udids_.get(index);
    }

    // optional bool usuallyFalse = 3;
    public static final int USUALLYFALSE_FIELD_NUMBER = 3;
    private boolean usuallyFalse_;
    /**
     * <code>optional bool usuallyFalse = 3;</code>
     */
    public boolean hasUsuallyFalse() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional bool usuallyFalse = 3;</code>
     */
    public boolean getUsuallyFalse() {
      return usuallyFalse_;
    }

    private void initFields() {
      psid_ = "";
      udids_ = java.util.Collections.emptyList();
      usuallyFalse_ = false;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasPsid()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getPsidBytes());
      }
      for (int i = 0; i < udids_.size(); i++) {
        output.writeBytes(2, udids_.get(i));
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBool(3, usuallyFalse_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getPsidBytes());
      }
      {
        int dataSize = 0;
        for (int i = 0; i < udids_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeBytesSizeNoTag(udids_.get(i));
        }
        size += dataSize;
        size += 1 * getUdidsList().size();
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(3, usuallyFalse_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static Protobuf.DeviceUdids parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Protobuf.DeviceUdids parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Protobuf.DeviceUdids parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Protobuf.DeviceUdids parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Protobuf.DeviceUdids parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static Protobuf.DeviceUdids parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static Protobuf.DeviceUdids parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static Protobuf.DeviceUdids parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static Protobuf.DeviceUdids parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static Protobuf.DeviceUdids parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(Protobuf.DeviceUdids prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code DeviceUdids}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements Protobuf.DeviceUdidsOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Protobuf.internal_static_DeviceUdids_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Protobuf.internal_static_DeviceUdids_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Protobuf.DeviceUdids.class, Protobuf.DeviceUdids.Builder.class);
      }

      // Construct using Protobuf.DeviceUdids.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        psid_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        udids_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        usuallyFalse_ = false;
        bitField0_ = (bitField0_ & ~0x00000004);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Protobuf.internal_static_DeviceUdids_descriptor;
      }

      public Protobuf.DeviceUdids getDefaultInstanceForType() {
        return Protobuf.DeviceUdids.getDefaultInstance();
      }

      public Protobuf.DeviceUdids build() {
        Protobuf.DeviceUdids result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Protobuf.DeviceUdids buildPartial() {
        Protobuf.DeviceUdids result = new Protobuf.DeviceUdids(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.psid_ = psid_;
        if (((bitField0_ & 0x00000002) == 0x00000002)) {
          udids_ = java.util.Collections.unmodifiableList(udids_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.udids_ = udids_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000002;
        }
        result.usuallyFalse_ = usuallyFalse_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Protobuf.DeviceUdids) {
          return mergeFrom((Protobuf.DeviceUdids)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Protobuf.DeviceUdids other) {
        if (other == Protobuf.DeviceUdids.getDefaultInstance()) return this;
        if (other.hasPsid()) {
          bitField0_ |= 0x00000001;
          psid_ = other.psid_;
          onChanged();
        }
        if (!other.udids_.isEmpty()) {
          if (udids_.isEmpty()) {
            udids_ = other.udids_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureUdidsIsMutable();
            udids_.addAll(other.udids_);
          }
          onChanged();
        }
        if (other.hasUsuallyFalse()) {
          setUsuallyFalse(other.getUsuallyFalse());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasPsid()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Protobuf.DeviceUdids parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Protobuf.DeviceUdids) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required string psid = 1;
      private java.lang.Object psid_ = "";
      /**
       * <code>required string psid = 1;</code>
       */
      public boolean hasPsid() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string psid = 1;</code>
       */
      public java.lang.String getPsid() {
        java.lang.Object ref = psid_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          psid_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string psid = 1;</code>
       */
      public com.google.protobuf.ByteString
          getPsidBytes() {
        java.lang.Object ref = psid_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          psid_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string psid = 1;</code>
       */
      public Builder setPsid(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        psid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string psid = 1;</code>
       */
      public Builder clearPsid() {
        bitField0_ = (bitField0_ & ~0x00000001);
        psid_ = getDefaultInstance().getPsid();
        onChanged();
        return this;
      }
      /**
       * <code>required string psid = 1;</code>
       */
      public Builder setPsidBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        psid_ = value;
        onChanged();
        return this;
      }

      // repeated bytes udids = 2;
      private java.util.List<com.google.protobuf.ByteString> udids_ = java.util.Collections.emptyList();
      private void ensureUdidsIsMutable() {
        if (!((bitField0_ & 0x00000002) == 0x00000002)) {
          udids_ = new java.util.ArrayList<com.google.protobuf.ByteString>(udids_);
          bitField0_ |= 0x00000002;
         }
      }
      /**
       * <code>repeated bytes udids = 2;</code>
       */
      public java.util.List<com.google.protobuf.ByteString>
          getUdidsList() {
        return java.util.Collections.unmodifiableList(udids_);
      }
      /**
       * <code>repeated bytes udids = 2;</code>
       */
      public int getUdidsCount() {
        return udids_.size();
      }
      /**
       * <code>repeated bytes udids = 2;</code>
       */
      public com.google.protobuf.ByteString getUdids(int index) {
        return udids_.get(index);
      }
      /**
       * <code>repeated bytes udids = 2;</code>
       */
      public Builder setUdids(
          int index, com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureUdidsIsMutable();
        udids_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated bytes udids = 2;</code>
       */
      public Builder addUdids(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureUdidsIsMutable();
        udids_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated bytes udids = 2;</code>
       */
      public Builder addAllUdids(
          java.lang.Iterable<? extends com.google.protobuf.ByteString> values) {
        ensureUdidsIsMutable();
        super.addAll(values, udids_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated bytes udids = 2;</code>
       */
      public Builder clearUdids() {
        udids_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
        return this;
      }

      // optional bool usuallyFalse = 3;
      private boolean usuallyFalse_ ;
      /**
       * <code>optional bool usuallyFalse = 3;</code>
       */
      public boolean hasUsuallyFalse() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>optional bool usuallyFalse = 3;</code>
       */
      public boolean getUsuallyFalse() {
        return usuallyFalse_;
      }
      /**
       * <code>optional bool usuallyFalse = 3;</code>
       */
      public Builder setUsuallyFalse(boolean value) {
        bitField0_ |= 0x00000004;
        usuallyFalse_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bool usuallyFalse = 3;</code>
       */
      public Builder clearUsuallyFalse() {
        bitField0_ = (bitField0_ & ~0x00000004);
        usuallyFalse_ = false;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:DeviceUdids)
    }

    static {
      defaultInstance = new DeviceUdids(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:DeviceUdids)
  }

  public interface DeviceOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required bytes udid = 1;
    /**
     * <code>required bytes udid = 1;</code>
     */
    boolean hasUdid();
    /**
     * <code>required bytes udid = 1;</code>
     */
    com.google.protobuf.ByteString getUdid();

    // required int64 fullSize = 2;
    /**
     * <code>required int64 fullSize = 2;</code>
     */
    boolean hasFullSize();
    /**
     * <code>required int64 fullSize = 2;</code>
     */
    long getFullSize();

    // repeated .Backup backup = 3;
    /**
     * <code>repeated .Backup backup = 3;</code>
     */
    java.util.List<Protobuf.Backup> 
        getBackupList();
    /**
     * <code>repeated .Backup backup = 3;</code>
     */
    Protobuf.Backup getBackup(int index);
    /**
     * <code>repeated .Backup backup = 3;</code>
     */
    int getBackupCount();
    /**
     * <code>repeated .Backup backup = 3;</code>
     */
    java.util.List<? extends Protobuf.BackupOrBuilder> 
        getBackupOrBuilderList();
    /**
     * <code>repeated .Backup backup = 3;</code>
     */
    Protobuf.BackupOrBuilder getBackupOrBuilder(
        int index);

    // required .DeviceInfo device = 4;
    /**
     * <code>required .DeviceInfo device = 4;</code>
     */
    boolean hasDevice();
    /**
     * <code>required .DeviceInfo device = 4;</code>
     */
    Protobuf.DeviceInfo getDevice();
    /**
     * <code>required .DeviceInfo device = 4;</code>
     */
    Protobuf.DeviceInfoOrBuilder getDeviceOrBuilder();

    // required int64 time = 5;
    /**
     * <code>required int64 time = 5;</code>
     */
    boolean hasTime();
    /**
     * <code>required int64 time = 5;</code>
     */
    long getTime();
  }
  /**
   * Protobuf type {@code Device}
   */
  public static final class Device extends
      com.google.protobuf.GeneratedMessage
      implements DeviceOrBuilder {
    // Use Device.newBuilder() to construct.
    private Device(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private Device(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final Device defaultInstance;
    public static Device getDefaultInstance() {
      return defaultInstance;
    }

    public Device getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private Device(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              bitField0_ |= 0x00000001;
              udid_ = input.readBytes();
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              fullSize_ = input.readInt64();
              break;
            }
            case 26: {
              if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
                backup_ = new java.util.ArrayList<Protobuf.Backup>();
                mutable_bitField0_ |= 0x00000004;
              }
              backup_.add(input.readMessage(Protobuf.Backup.PARSER, extensionRegistry));
              break;
            }
            case 34: {
              Protobuf.DeviceInfo.Builder subBuilder = null;
              if (((bitField0_ & 0x00000004) == 0x00000004)) {
                subBuilder = device_.toBuilder();
              }
              device_ = input.readMessage(Protobuf.DeviceInfo.PARSER, extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(device_);
                device_ = subBuilder.buildPartial();
              }
              bitField0_ |= 0x00000004;
              break;
            }
            case 40: {
              bitField0_ |= 0x00000008;
              time_ = input.readInt64();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
          backup_ = java.util.Collections.unmodifiableList(backup_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Protobuf.internal_static_Device_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Protobuf.internal_static_Device_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Protobuf.Device.class, Protobuf.Device.Builder.class);
    }

    public static com.google.protobuf.Parser<Device> PARSER =
        new com.google.protobuf.AbstractParser<Device>() {
      public Device parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Device(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<Device> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required bytes udid = 1;
    public static final int UDID_FIELD_NUMBER = 1;
    private com.google.protobuf.ByteString udid_;
    /**
     * <code>required bytes udid = 1;</code>
     */
    public boolean hasUdid() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required bytes udid = 1;</code>
     */
    public com.google.protobuf.ByteString getUdid() {
      return udid_;
    }

    // required int64 fullSize = 2;
    public static final int FULLSIZE_FIELD_NUMBER = 2;
    private long fullSize_;
    /**
     * <code>required int64 fullSize = 2;</code>
     */
    public boolean hasFullSize() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required int64 fullSize = 2;</code>
     */
    public long getFullSize() {
      return fullSize_;
    }

    // repeated .Backup backup = 3;
    public static final int BACKUP_FIELD_NUMBER = 3;
    private java.util.List<Protobuf.Backup> backup_;
    /**
     * <code>repeated .Backup backup = 3;</code>
     */
    public java.util.List<Protobuf.Backup> getBackupList() {
      return backup_;
    }
    /**
     * <code>repeated .Backup backup = 3;</code>
     */
    public java.util.List<? extends Protobuf.BackupOrBuilder> 
        getBackupOrBuilderList() {
      return backup_;
    }
    /**
     * <code>repeated .Backup backup = 3;</code>
     */
    public int getBackupCount() {
      return backup_.size();
    }
    /**
     * <code>repeated .Backup backup = 3;</code>
     */
    public Protobuf.Backup getBackup(int index) {
      return backup_.get(index);
    }
    /**
     * <code>repeated .Backup backup = 3;</code>
     */
    public Protobuf.BackupOrBuilder getBackupOrBuilder(
        int index) {
      return backup_.get(index);
    }

    // required .DeviceInfo device = 4;
    public static final int DEVICE_FIELD_NUMBER = 4;
    private Protobuf.DeviceInfo device_;
    /**
     * <code>required .DeviceInfo device = 4;</code>
     */
    public boolean hasDevice() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required .DeviceInfo device = 4;</code>
     */
    public Protobuf.DeviceInfo getDevice() {
      return device_;
    }
    /**
     * <code>required .DeviceInfo device = 4;</code>
     */
    public Protobuf.DeviceInfoOrBuilder getDeviceOrBuilder() {
      return device_;
    }

    // required int64 time = 5;
    public static final int TIME_FIELD_NUMBER = 5;
    private long time_;
    /**
     * <code>required int64 time = 5;</code>
     */
    public boolean hasTime() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>required int64 time = 5;</code>
     */
    public long getTime() {
      return time_;
    }

    private void initFields() {
      udid_ = com.google.protobuf.ByteString.EMPTY;
      fullSize_ = 0L;
      backup_ = java.util.Collections.emptyList();
      device_ = Protobuf.DeviceInfo.getDefaultInstance();
      time_ = 0L;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasUdid()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasFullSize()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasDevice()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasTime()) {
        memoizedIsInitialized = 0;
        return false;
      }
      for (int i = 0; i < getBackupCount(); i++) {
        if (!getBackup(i).isInitialized()) {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      if (!getDevice().isInitialized()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, udid_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeInt64(2, fullSize_);
      }
      for (int i = 0; i < backup_.size(); i++) {
        output.writeMessage(3, backup_.get(i));
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeMessage(4, device_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeInt64(5, time_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, udid_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(2, fullSize_);
      }
      for (int i = 0; i < backup_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(3, backup_.get(i));
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(4, device_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(5, time_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static Protobuf.Device parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Protobuf.Device parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Protobuf.Device parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Protobuf.Device parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Protobuf.Device parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static Protobuf.Device parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static Protobuf.Device parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static Protobuf.Device parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static Protobuf.Device parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static Protobuf.Device parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(Protobuf.Device prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Device}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements Protobuf.DeviceOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Protobuf.internal_static_Device_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Protobuf.internal_static_Device_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Protobuf.Device.class, Protobuf.Device.Builder.class);
      }

      // Construct using Protobuf.Device.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
          getBackupFieldBuilder();
          getDeviceFieldBuilder();
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        udid_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        fullSize_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000002);
        if (backupBuilder_ == null) {
          backup_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000004);
        } else {
          backupBuilder_.clear();
        }
        if (deviceBuilder_ == null) {
          device_ = Protobuf.DeviceInfo.getDefaultInstance();
        } else {
          deviceBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000008);
        time_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000010);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Protobuf.internal_static_Device_descriptor;
      }

      public Protobuf.Device getDefaultInstanceForType() {
        return Protobuf.Device.getDefaultInstance();
      }

      public Protobuf.Device build() {
        Protobuf.Device result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Protobuf.Device buildPartial() {
        Protobuf.Device result = new Protobuf.Device(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.udid_ = udid_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.fullSize_ = fullSize_;
        if (backupBuilder_ == null) {
          if (((bitField0_ & 0x00000004) == 0x00000004)) {
            backup_ = java.util.Collections.unmodifiableList(backup_);
            bitField0_ = (bitField0_ & ~0x00000004);
          }
          result.backup_ = backup_;
        } else {
          result.backup_ = backupBuilder_.build();
        }
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000004;
        }
        if (deviceBuilder_ == null) {
          result.device_ = device_;
        } else {
          result.device_ = deviceBuilder_.build();
        }
        if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
          to_bitField0_ |= 0x00000008;
        }
        result.time_ = time_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Protobuf.Device) {
          return mergeFrom((Protobuf.Device)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Protobuf.Device other) {
        if (other == Protobuf.Device.getDefaultInstance()) return this;
        if (other.hasUdid()) {
          setUdid(other.getUdid());
        }
        if (other.hasFullSize()) {
          setFullSize(other.getFullSize());
        }
        if (backupBuilder_ == null) {
          if (!other.backup_.isEmpty()) {
            if (backup_.isEmpty()) {
              backup_ = other.backup_;
              bitField0_ = (bitField0_ & ~0x00000004);
            } else {
              ensureBackupIsMutable();
              backup_.addAll(other.backup_);
            }
            onChanged();
          }
        } else {
          if (!other.backup_.isEmpty()) {
            if (backupBuilder_.isEmpty()) {
              backupBuilder_.dispose();
              backupBuilder_ = null;
              backup_ = other.backup_;
              bitField0_ = (bitField0_ & ~0x00000004);
              backupBuilder_ = 
                com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ?
                   getBackupFieldBuilder() : null;
            } else {
              backupBuilder_.addAllMessages(other.backup_);
            }
          }
        }
        if (other.hasDevice()) {
          mergeDevice(other.getDevice());
        }
        if (other.hasTime()) {
          setTime(other.getTime());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasUdid()) {
          
          return false;
        }
        if (!hasFullSize()) {
          
          return false;
        }
        if (!hasDevice()) {
          
          return false;
        }
        if (!hasTime()) {
          
          return false;
        }
        for (int i = 0; i < getBackupCount(); i++) {
          if (!getBackup(i).isInitialized()) {
            
            return false;
          }
        }
        if (!getDevice().isInitialized()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Protobuf.Device parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Protobuf.Device) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required bytes udid = 1;
      private com.google.protobuf.ByteString udid_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>required bytes udid = 1;</code>
       */
      public boolean hasUdid() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required bytes udid = 1;</code>
       */
      public com.google.protobuf.ByteString getUdid() {
        return udid_;
      }
      /**
       * <code>required bytes udid = 1;</code>
       */
      public Builder setUdid(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        udid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required bytes udid = 1;</code>
       */
      public Builder clearUdid() {
        bitField0_ = (bitField0_ & ~0x00000001);
        udid_ = getDefaultInstance().getUdid();
        onChanged();
        return this;
      }

      // required int64 fullSize = 2;
      private long fullSize_ ;
      /**
       * <code>required int64 fullSize = 2;</code>
       */
      public boolean hasFullSize() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required int64 fullSize = 2;</code>
       */
      public long getFullSize() {
        return fullSize_;
      }
      /**
       * <code>required int64 fullSize = 2;</code>
       */
      public Builder setFullSize(long value) {
        bitField0_ |= 0x00000002;
        fullSize_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int64 fullSize = 2;</code>
       */
      public Builder clearFullSize() {
        bitField0_ = (bitField0_ & ~0x00000002);
        fullSize_ = 0L;
        onChanged();
        return this;
      }

      // repeated .Backup backup = 3;
      private java.util.List<Protobuf.Backup> backup_ =
        java.util.Collections.emptyList();
      private void ensureBackupIsMutable() {
        if (!((bitField0_ & 0x00000004) == 0x00000004)) {
          backup_ = new java.util.ArrayList<Protobuf.Backup>(backup_);
          bitField0_ |= 0x00000004;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilder<
          Protobuf.Backup, Protobuf.Backup.Builder, Protobuf.BackupOrBuilder> backupBuilder_;

      /**
       * <code>repeated .Backup backup = 3;</code>
       */
      public java.util.List<Protobuf.Backup> getBackupList() {
        if (backupBuilder_ == null) {
          return java.util.Collections.unmodifiableList(backup_);
        } else {
          return backupBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .Backup backup = 3;</code>
       */
      public int getBackupCount() {
        if (backupBuilder_ == null) {
          return backup_.size();
        } else {
          return backupBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .Backup backup = 3;</code>
       */
      public Protobuf.Backup getBackup(int index) {
        if (backupBuilder_ == null) {
          return backup_.get(index);
        } else {
          return backupBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .Backup backup = 3;</code>
       */
      public Builder setBackup(
          int index, Protobuf.Backup value) {
        if (backupBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureBackupIsMutable();
          backup_.set(index, value);
          onChanged();
        } else {
          backupBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .Backup backup = 3;</code>
       */
      public Builder setBackup(
          int index, Protobuf.Backup.Builder builderForValue) {
        if (backupBuilder_ == null) {
          ensureBackupIsMutable();
          backup_.set(index, builderForValue.build());
          onChanged();
        } else {
          backupBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Backup backup = 3;</code>
       */
      public Builder addBackup(Protobuf.Backup value) {
        if (backupBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureBackupIsMutable();
          backup_.add(value);
          onChanged();
        } else {
          backupBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .Backup backup = 3;</code>
       */
      public Builder addBackup(
          int index, Protobuf.Backup value) {
        if (backupBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureBackupIsMutable();
          backup_.add(index, value);
          onChanged();
        } else {
          backupBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .Backup backup = 3;</code>
       */
      public Builder addBackup(
          Protobuf.Backup.Builder builderForValue) {
        if (backupBuilder_ == null) {
          ensureBackupIsMutable();
          backup_.add(builderForValue.build());
          onChanged();
        } else {
          backupBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Backup backup = 3;</code>
       */
      public Builder addBackup(
          int index, Protobuf.Backup.Builder builderForValue) {
        if (backupBuilder_ == null) {
          ensureBackupIsMutable();
          backup_.add(index, builderForValue.build());
          onChanged();
        } else {
          backupBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Backup backup = 3;</code>
       */
      public Builder addAllBackup(
          java.lang.Iterable<? extends Protobuf.Backup> values) {
        if (backupBuilder_ == null) {
          ensureBackupIsMutable();
          super.addAll(values, backup_);
          onChanged();
        } else {
          backupBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .Backup backup = 3;</code>
       */
      public Builder clearBackup() {
        if (backupBuilder_ == null) {
          backup_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000004);
          onChanged();
        } else {
          backupBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .Backup backup = 3;</code>
       */
      public Builder removeBackup(int index) {
        if (backupBuilder_ == null) {
          ensureBackupIsMutable();
          backup_.remove(index);
          onChanged();
        } else {
          backupBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .Backup backup = 3;</code>
       */
      public Protobuf.Backup.Builder getBackupBuilder(
          int index) {
        return getBackupFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .Backup backup = 3;</code>
       */
      public Protobuf.BackupOrBuilder getBackupOrBuilder(
          int index) {
        if (backupBuilder_ == null) {
          return backup_.get(index);  } else {
          return backupBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .Backup backup = 3;</code>
       */
      public java.util.List<? extends Protobuf.BackupOrBuilder> 
           getBackupOrBuilderList() {
        if (backupBuilder_ != null) {
          return backupBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(backup_);
        }
      }
      /**
       * <code>repeated .Backup backup = 3;</code>
       */
      public Protobuf.Backup.Builder addBackupBuilder() {
        return getBackupFieldBuilder().addBuilder(
            Protobuf.Backup.getDefaultInstance());
      }
      /**
       * <code>repeated .Backup backup = 3;</code>
       */
      public Protobuf.Backup.Builder addBackupBuilder(
          int index) {
        return getBackupFieldBuilder().addBuilder(
            index, Protobuf.Backup.getDefaultInstance());
      }
      /**
       * <code>repeated .Backup backup = 3;</code>
       */
      public java.util.List<Protobuf.Backup.Builder> 
           getBackupBuilderList() {
        return getBackupFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilder<
          Protobuf.Backup, Protobuf.Backup.Builder, Protobuf.BackupOrBuilder> 
          getBackupFieldBuilder() {
        if (backupBuilder_ == null) {
          backupBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
              Protobuf.Backup, Protobuf.Backup.Builder, Protobuf.BackupOrBuilder>(
                  backup_,
                  ((bitField0_ & 0x00000004) == 0x00000004),
                  getParentForChildren(),
                  isClean());
          backup_ = null;
        }
        return backupBuilder_;
      }

      // required .DeviceInfo device = 4;
      private Protobuf.DeviceInfo device_ = Protobuf.DeviceInfo.getDefaultInstance();
      private com.google.protobuf.SingleFieldBuilder<
          Protobuf.DeviceInfo, Protobuf.DeviceInfo.Builder, Protobuf.DeviceInfoOrBuilder> deviceBuilder_;
      /**
       * <code>required .DeviceInfo device = 4;</code>
       */
      public boolean hasDevice() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>required .DeviceInfo device = 4;</code>
       */
      public Protobuf.DeviceInfo getDevice() {
        if (deviceBuilder_ == null) {
          return device_;
        } else {
          return deviceBuilder_.getMessage();
        }
      }
      /**
       * <code>required .DeviceInfo device = 4;</code>
       */
      public Builder setDevice(Protobuf.DeviceInfo value) {
        if (deviceBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          device_ = value;
          onChanged();
        } else {
          deviceBuilder_.setMessage(value);
        }
        bitField0_ |= 0x00000008;
        return this;
      }
      /**
       * <code>required .DeviceInfo device = 4;</code>
       */
      public Builder setDevice(
          Protobuf.DeviceInfo.Builder builderForValue) {
        if (deviceBuilder_ == null) {
          device_ = builderForValue.build();
          onChanged();
        } else {
          deviceBuilder_.setMessage(builderForValue.build());
        }
        bitField0_ |= 0x00000008;
        return this;
      }
      /**
       * <code>required .DeviceInfo device = 4;</code>
       */
      public Builder mergeDevice(Protobuf.DeviceInfo value) {
        if (deviceBuilder_ == null) {
          if (((bitField0_ & 0x00000008) == 0x00000008) &&
              device_ != Protobuf.DeviceInfo.getDefaultInstance()) {
            device_ =
              Protobuf.DeviceInfo.newBuilder(device_).mergeFrom(value).buildPartial();
          } else {
            device_ = value;
          }
          onChanged();
        } else {
          deviceBuilder_.mergeFrom(value);
        }
        bitField0_ |= 0x00000008;
        return this;
      }
      /**
       * <code>required .DeviceInfo device = 4;</code>
       */
      public Builder clearDevice() {
        if (deviceBuilder_ == null) {
          device_ = Protobuf.DeviceInfo.getDefaultInstance();
          onChanged();
        } else {
          deviceBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000008);
        return this;
      }
      /**
       * <code>required .DeviceInfo device = 4;</code>
       */
      public Protobuf.DeviceInfo.Builder getDeviceBuilder() {
        bitField0_ |= 0x00000008;
        onChanged();
        return getDeviceFieldBuilder().getBuilder();
      }
      /**
       * <code>required .DeviceInfo device = 4;</code>
       */
      public Protobuf.DeviceInfoOrBuilder getDeviceOrBuilder() {
        if (deviceBuilder_ != null) {
          return deviceBuilder_.getMessageOrBuilder();
        } else {
          return device_;
        }
      }
      /**
       * <code>required .DeviceInfo device = 4;</code>
       */
      private com.google.protobuf.SingleFieldBuilder<
          Protobuf.DeviceInfo, Protobuf.DeviceInfo.Builder, Protobuf.DeviceInfoOrBuilder> 
          getDeviceFieldBuilder() {
        if (deviceBuilder_ == null) {
          deviceBuilder_ = new com.google.protobuf.SingleFieldBuilder<
              Protobuf.DeviceInfo, Protobuf.DeviceInfo.Builder, Protobuf.DeviceInfoOrBuilder>(
                  device_,
                  getParentForChildren(),
                  isClean());
          device_ = null;
        }
        return deviceBuilder_;
      }

      // required int64 time = 5;
      private long time_ ;
      /**
       * <code>required int64 time = 5;</code>
       */
      public boolean hasTime() {
        return ((bitField0_ & 0x00000010) == 0x00000010);
      }
      /**
       * <code>required int64 time = 5;</code>
       */
      public long getTime() {
        return time_;
      }
      /**
       * <code>required int64 time = 5;</code>
       */
      public Builder setTime(long value) {
        bitField0_ |= 0x00000010;
        time_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int64 time = 5;</code>
       */
      public Builder clearTime() {
        bitField0_ = (bitField0_ & ~0x00000010);
        time_ = 0L;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:Device)
    }

    static {
      defaultInstance = new Device(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:Device)
  }

  public interface BackupOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required int32 snapshotID = 1;
    /**
     * <code>required int32 snapshotID = 1;</code>
     */
    boolean hasSnapshotID();
    /**
     * <code>required int32 snapshotID = 1;</code>
     */
    int getSnapshotID();

    // required int64 size = 2;
    /**
     * <code>required int64 size = 2;</code>
     */
    boolean hasSize();
    /**
     * <code>required int64 size = 2;</code>
     */
    long getSize();

    // required int64 time1 = 3;
    /**
     * <code>required int64 time1 = 3;</code>
     */
    boolean hasTime1();
    /**
     * <code>required int64 time1 = 3;</code>
     */
    long getTime1();

    // required .BackupInfo info = 5;
    /**
     * <code>required .BackupInfo info = 5;</code>
     */
    boolean hasInfo();
    /**
     * <code>required .BackupInfo info = 5;</code>
     */
    Protobuf.BackupInfo getInfo();
    /**
     * <code>required .BackupInfo info = 5;</code>
     */
    Protobuf.BackupInfoOrBuilder getInfoOrBuilder();

    // required int64 time2 = 6;
    /**
     * <code>required int64 time2 = 6;</code>
     */
    boolean hasTime2();
    /**
     * <code>required int64 time2 = 6;</code>
     */
    long getTime2();
  }
  /**
   * Protobuf type {@code Backup}
   */
  public static final class Backup extends
      com.google.protobuf.GeneratedMessage
      implements BackupOrBuilder {
    // Use Backup.newBuilder() to construct.
    private Backup(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private Backup(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final Backup defaultInstance;
    public static Backup getDefaultInstance() {
      return defaultInstance;
    }

    public Backup getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private Backup(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              snapshotID_ = input.readInt32();
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              size_ = input.readInt64();
              break;
            }
            case 24: {
              bitField0_ |= 0x00000004;
              time1_ = input.readInt64();
              break;
            }
            case 42: {
              Protobuf.BackupInfo.Builder subBuilder = null;
              if (((bitField0_ & 0x00000008) == 0x00000008)) {
                subBuilder = info_.toBuilder();
              }
              info_ = input.readMessage(Protobuf.BackupInfo.PARSER, extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(info_);
                info_ = subBuilder.buildPartial();
              }
              bitField0_ |= 0x00000008;
              break;
            }
            case 48: {
              bitField0_ |= 0x00000010;
              time2_ = input.readInt64();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Protobuf.internal_static_Backup_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Protobuf.internal_static_Backup_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Protobuf.Backup.class, Protobuf.Backup.Builder.class);
    }

    public static com.google.protobuf.Parser<Backup> PARSER =
        new com.google.protobuf.AbstractParser<Backup>() {
      public Backup parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Backup(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<Backup> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required int32 snapshotID = 1;
    public static final int SNAPSHOTID_FIELD_NUMBER = 1;
    private int snapshotID_;
    /**
     * <code>required int32 snapshotID = 1;</code>
     */
    public boolean hasSnapshotID() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required int32 snapshotID = 1;</code>
     */
    public int getSnapshotID() {
      return snapshotID_;
    }

    // required int64 size = 2;
    public static final int SIZE_FIELD_NUMBER = 2;
    private long size_;
    /**
     * <code>required int64 size = 2;</code>
     */
    public boolean hasSize() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required int64 size = 2;</code>
     */
    public long getSize() {
      return size_;
    }

    // required int64 time1 = 3;
    public static final int TIME1_FIELD_NUMBER = 3;
    private long time1_;
    /**
     * <code>required int64 time1 = 3;</code>
     */
    public boolean hasTime1() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required int64 time1 = 3;</code>
     */
    public long getTime1() {
      return time1_;
    }

    // required .BackupInfo info = 5;
    public static final int INFO_FIELD_NUMBER = 5;
    private Protobuf.BackupInfo info_;
    /**
     * <code>required .BackupInfo info = 5;</code>
     */
    public boolean hasInfo() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>required .BackupInfo info = 5;</code>
     */
    public Protobuf.BackupInfo getInfo() {
      return info_;
    }
    /**
     * <code>required .BackupInfo info = 5;</code>
     */
    public Protobuf.BackupInfoOrBuilder getInfoOrBuilder() {
      return info_;
    }

    // required int64 time2 = 6;
    public static final int TIME2_FIELD_NUMBER = 6;
    private long time2_;
    /**
     * <code>required int64 time2 = 6;</code>
     */
    public boolean hasTime2() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>required int64 time2 = 6;</code>
     */
    public long getTime2() {
      return time2_;
    }

    private void initFields() {
      snapshotID_ = 0;
      size_ = 0L;
      time1_ = 0L;
      info_ = Protobuf.BackupInfo.getDefaultInstance();
      time2_ = 0L;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasSnapshotID()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasSize()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasTime1()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasInfo()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasTime2()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!getInfo().isInitialized()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt32(1, snapshotID_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeInt64(2, size_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeInt64(3, time1_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeMessage(5, info_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        output.writeInt64(6, time2_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, snapshotID_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(2, size_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(3, time1_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(5, info_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(6, time2_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static Protobuf.Backup parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Protobuf.Backup parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Protobuf.Backup parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Protobuf.Backup parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Protobuf.Backup parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static Protobuf.Backup parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static Protobuf.Backup parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static Protobuf.Backup parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static Protobuf.Backup parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static Protobuf.Backup parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(Protobuf.Backup prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Backup}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements Protobuf.BackupOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Protobuf.internal_static_Backup_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Protobuf.internal_static_Backup_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Protobuf.Backup.class, Protobuf.Backup.Builder.class);
      }

      // Construct using Protobuf.Backup.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
          getInfoFieldBuilder();
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        snapshotID_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        size_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000002);
        time1_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000004);
        if (infoBuilder_ == null) {
          info_ = Protobuf.BackupInfo.getDefaultInstance();
        } else {
          infoBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000008);
        time2_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000010);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Protobuf.internal_static_Backup_descriptor;
      }

      public Protobuf.Backup getDefaultInstanceForType() {
        return Protobuf.Backup.getDefaultInstance();
      }

      public Protobuf.Backup build() {
        Protobuf.Backup result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Protobuf.Backup buildPartial() {
        Protobuf.Backup result = new Protobuf.Backup(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.snapshotID_ = snapshotID_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.size_ = size_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.time1_ = time1_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        if (infoBuilder_ == null) {
          result.info_ = info_;
        } else {
          result.info_ = infoBuilder_.build();
        }
        if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
          to_bitField0_ |= 0x00000010;
        }
        result.time2_ = time2_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Protobuf.Backup) {
          return mergeFrom((Protobuf.Backup)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Protobuf.Backup other) {
        if (other == Protobuf.Backup.getDefaultInstance()) return this;
        if (other.hasSnapshotID()) {
          setSnapshotID(other.getSnapshotID());
        }
        if (other.hasSize()) {
          setSize(other.getSize());
        }
        if (other.hasTime1()) {
          setTime1(other.getTime1());
        }
        if (other.hasInfo()) {
          mergeInfo(other.getInfo());
        }
        if (other.hasTime2()) {
          setTime2(other.getTime2());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasSnapshotID()) {
          
          return false;
        }
        if (!hasSize()) {
          
          return false;
        }
        if (!hasTime1()) {
          
          return false;
        }
        if (!hasInfo()) {
          
          return false;
        }
        if (!hasTime2()) {
          
          return false;
        }
        if (!getInfo().isInitialized()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Protobuf.Backup parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Protobuf.Backup) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required int32 snapshotID = 1;
      private int snapshotID_ ;
      /**
       * <code>required int32 snapshotID = 1;</code>
       */
      public boolean hasSnapshotID() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required int32 snapshotID = 1;</code>
       */
      public int getSnapshotID() {
        return snapshotID_;
      }
      /**
       * <code>required int32 snapshotID = 1;</code>
       */
      public Builder setSnapshotID(int value) {
        bitField0_ |= 0x00000001;
        snapshotID_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 snapshotID = 1;</code>
       */
      public Builder clearSnapshotID() {
        bitField0_ = (bitField0_ & ~0x00000001);
        snapshotID_ = 0;
        onChanged();
        return this;
      }

      // required int64 size = 2;
      private long size_ ;
      /**
       * <code>required int64 size = 2;</code>
       */
      public boolean hasSize() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required int64 size = 2;</code>
       */
      public long getSize() {
        return size_;
      }
      /**
       * <code>required int64 size = 2;</code>
       */
      public Builder setSize(long value) {
        bitField0_ |= 0x00000002;
        size_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int64 size = 2;</code>
       */
      public Builder clearSize() {
        bitField0_ = (bitField0_ & ~0x00000002);
        size_ = 0L;
        onChanged();
        return this;
      }

      // required int64 time1 = 3;
      private long time1_ ;
      /**
       * <code>required int64 time1 = 3;</code>
       */
      public boolean hasTime1() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>required int64 time1 = 3;</code>
       */
      public long getTime1() {
        return time1_;
      }
      /**
       * <code>required int64 time1 = 3;</code>
       */
      public Builder setTime1(long value) {
        bitField0_ |= 0x00000004;
        time1_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int64 time1 = 3;</code>
       */
      public Builder clearTime1() {
        bitField0_ = (bitField0_ & ~0x00000004);
        time1_ = 0L;
        onChanged();
        return this;
      }

      // required .BackupInfo info = 5;
      private Protobuf.BackupInfo info_ = Protobuf.BackupInfo.getDefaultInstance();
      private com.google.protobuf.SingleFieldBuilder<
          Protobuf.BackupInfo, Protobuf.BackupInfo.Builder, Protobuf.BackupInfoOrBuilder> infoBuilder_;
      /**
       * <code>required .BackupInfo info = 5;</code>
       */
      public boolean hasInfo() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>required .BackupInfo info = 5;</code>
       */
      public Protobuf.BackupInfo getInfo() {
        if (infoBuilder_ == null) {
          return info_;
        } else {
          return infoBuilder_.getMessage();
        }
      }
      /**
       * <code>required .BackupInfo info = 5;</code>
       */
      public Builder setInfo(Protobuf.BackupInfo value) {
        if (infoBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          info_ = value;
          onChanged();
        } else {
          infoBuilder_.setMessage(value);
        }
        bitField0_ |= 0x00000008;
        return this;
      }
      /**
       * <code>required .BackupInfo info = 5;</code>
       */
      public Builder setInfo(
          Protobuf.BackupInfo.Builder builderForValue) {
        if (infoBuilder_ == null) {
          info_ = builderForValue.build();
          onChanged();
        } else {
          infoBuilder_.setMessage(builderForValue.build());
        }
        bitField0_ |= 0x00000008;
        return this;
      }
      /**
       * <code>required .BackupInfo info = 5;</code>
       */
      public Builder mergeInfo(Protobuf.BackupInfo value) {
        if (infoBuilder_ == null) {
          if (((bitField0_ & 0x00000008) == 0x00000008) &&
              info_ != Protobuf.BackupInfo.getDefaultInstance()) {
            info_ =
              Protobuf.BackupInfo.newBuilder(info_).mergeFrom(value).buildPartial();
          } else {
            info_ = value;
          }
          onChanged();
        } else {
          infoBuilder_.mergeFrom(value);
        }
        bitField0_ |= 0x00000008;
        return this;
      }
      /**
       * <code>required .BackupInfo info = 5;</code>
       */
      public Builder clearInfo() {
        if (infoBuilder_ == null) {
          info_ = Protobuf.BackupInfo.getDefaultInstance();
          onChanged();
        } else {
          infoBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000008);
        return this;
      }
      /**
       * <code>required .BackupInfo info = 5;</code>
       */
      public Protobuf.BackupInfo.Builder getInfoBuilder() {
        bitField0_ |= 0x00000008;
        onChanged();
        return getInfoFieldBuilder().getBuilder();
      }
      /**
       * <code>required .BackupInfo info = 5;</code>
       */
      public Protobuf.BackupInfoOrBuilder getInfoOrBuilder() {
        if (infoBuilder_ != null) {
          return infoBuilder_.getMessageOrBuilder();
        } else {
          return info_;
        }
      }
      /**
       * <code>required .BackupInfo info = 5;</code>
       */
      private com.google.protobuf.SingleFieldBuilder<
          Protobuf.BackupInfo, Protobuf.BackupInfo.Builder, Protobuf.BackupInfoOrBuilder> 
          getInfoFieldBuilder() {
        if (infoBuilder_ == null) {
          infoBuilder_ = new com.google.protobuf.SingleFieldBuilder<
              Protobuf.BackupInfo, Protobuf.BackupInfo.Builder, Protobuf.BackupInfoOrBuilder>(
                  info_,
                  getParentForChildren(),
                  isClean());
          info_ = null;
        }
        return infoBuilder_;
      }

      // required int64 time2 = 6;
      private long time2_ ;
      /**
       * <code>required int64 time2 = 6;</code>
       */
      public boolean hasTime2() {
        return ((bitField0_ & 0x00000010) == 0x00000010);
      }
      /**
       * <code>required int64 time2 = 6;</code>
       */
      public long getTime2() {
        return time2_;
      }
      /**
       * <code>required int64 time2 = 6;</code>
       */
      public Builder setTime2(long value) {
        bitField0_ |= 0x00000010;
        time2_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int64 time2 = 6;</code>
       */
      public Builder clearTime2() {
        bitField0_ = (bitField0_ & ~0x00000010);
        time2_ = 0L;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:Backup)
    }

    static {
      defaultInstance = new Backup(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:Backup)
  }

  public interface BackupInfoOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required string name = 1;
    /**
     * <code>required string name = 1;</code>
     */
    boolean hasName();
    /**
     * <code>required string name = 1;</code>
     */
    java.lang.String getName();
    /**
     * <code>required string name = 1;</code>
     */
    com.google.protobuf.ByteString
        getNameBytes();

    // required string firmware = 2;
    /**
     * <code>required string firmware = 2;</code>
     */
    boolean hasFirmware();
    /**
     * <code>required string firmware = 2;</code>
     */
    java.lang.String getFirmware();
    /**
     * <code>required string firmware = 2;</code>
     */
    com.google.protobuf.ByteString
        getFirmwareBytes();

    // required string build = 3;
    /**
     * <code>required string build = 3;</code>
     */
    boolean hasBuild();
    /**
     * <code>required string build = 3;</code>
     */
    java.lang.String getBuild();
    /**
     * <code>required string build = 3;</code>
     */
    com.google.protobuf.ByteString
        getBuildBytes();

    // required int32 usually2_1 = 4;
    /**
     * <code>required int32 usually2_1 = 4;</code>
     */
    boolean hasUsually21();
    /**
     * <code>required int32 usually2_1 = 4;</code>
     */
    int getUsually21();

    // required bytes idk = 5;
    /**
     * <code>required bytes idk = 5;</code>
     */
    boolean hasIdk();
    /**
     * <code>required bytes idk = 5;</code>
     */
    com.google.protobuf.ByteString getIdk();

    // required int32 usually2_2 = 6;
    /**
     * <code>required int32 usually2_2 = 6;</code>
     */
    boolean hasUsually22();
    /**
     * <code>required int32 usually2_2 = 6;</code>
     */
    int getUsually22();

    // required int32 usually1 = 7;
    /**
     * <code>required int32 usually1 = 7;</code>
     */
    boolean hasUsually1();
    /**
     * <code>required int32 usually1 = 7;</code>
     */
    int getUsually1();
  }
  /**
   * Protobuf type {@code BackupInfo}
   */
  public static final class BackupInfo extends
      com.google.protobuf.GeneratedMessage
      implements BackupInfoOrBuilder {
    // Use BackupInfo.newBuilder() to construct.
    private BackupInfo(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private BackupInfo(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final BackupInfo defaultInstance;
    public static BackupInfo getDefaultInstance() {
      return defaultInstance;
    }

    public BackupInfo getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private BackupInfo(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              bitField0_ |= 0x00000001;
              name_ = input.readBytes();
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              firmware_ = input.readBytes();
              break;
            }
            case 26: {
              bitField0_ |= 0x00000004;
              build_ = input.readBytes();
              break;
            }
            case 32: {
              bitField0_ |= 0x00000008;
              usually21_ = input.readInt32();
              break;
            }
            case 42: {
              bitField0_ |= 0x00000010;
              idk_ = input.readBytes();
              break;
            }
            case 48: {
              bitField0_ |= 0x00000020;
              usually22_ = input.readInt32();
              break;
            }
            case 56: {
              bitField0_ |= 0x00000040;
              usually1_ = input.readInt32();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Protobuf.internal_static_BackupInfo_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Protobuf.internal_static_BackupInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Protobuf.BackupInfo.class, Protobuf.BackupInfo.Builder.class);
    }

    public static com.google.protobuf.Parser<BackupInfo> PARSER =
        new com.google.protobuf.AbstractParser<BackupInfo>() {
      public BackupInfo parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new BackupInfo(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<BackupInfo> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required string name = 1;
    public static final int NAME_FIELD_NUMBER = 1;
    private java.lang.Object name_;
    /**
     * <code>required string name = 1;</code>
     */
    public boolean hasName() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string name = 1;</code>
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          name_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string name = 1;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // required string firmware = 2;
    public static final int FIRMWARE_FIELD_NUMBER = 2;
    private java.lang.Object firmware_;
    /**
     * <code>required string firmware = 2;</code>
     */
    public boolean hasFirmware() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string firmware = 2;</code>
     */
    public java.lang.String getFirmware() {
      java.lang.Object ref = firmware_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          firmware_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string firmware = 2;</code>
     */
    public com.google.protobuf.ByteString
        getFirmwareBytes() {
      java.lang.Object ref = firmware_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        firmware_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // required string build = 3;
    public static final int BUILD_FIELD_NUMBER = 3;
    private java.lang.Object build_;
    /**
     * <code>required string build = 3;</code>
     */
    public boolean hasBuild() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required string build = 3;</code>
     */
    public java.lang.String getBuild() {
      java.lang.Object ref = build_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          build_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string build = 3;</code>
     */
    public com.google.protobuf.ByteString
        getBuildBytes() {
      java.lang.Object ref = build_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        build_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // required int32 usually2_1 = 4;
    public static final int USUALLY2_1_FIELD_NUMBER = 4;
    private int usually21_;
    /**
     * <code>required int32 usually2_1 = 4;</code>
     */
    public boolean hasUsually21() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>required int32 usually2_1 = 4;</code>
     */
    public int getUsually21() {
      return usually21_;
    }

    // required bytes idk = 5;
    public static final int IDK_FIELD_NUMBER = 5;
    private com.google.protobuf.ByteString idk_;
    /**
     * <code>required bytes idk = 5;</code>
     */
    public boolean hasIdk() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>required bytes idk = 5;</code>
     */
    public com.google.protobuf.ByteString getIdk() {
      return idk_;
    }

    // required int32 usually2_2 = 6;
    public static final int USUALLY2_2_FIELD_NUMBER = 6;
    private int usually22_;
    /**
     * <code>required int32 usually2_2 = 6;</code>
     */
    public boolean hasUsually22() {
      return ((bitField0_ & 0x00000020) == 0x00000020);
    }
    /**
     * <code>required int32 usually2_2 = 6;</code>
     */
    public int getUsually22() {
      return usually22_;
    }

    // required int32 usually1 = 7;
    public static final int USUALLY1_FIELD_NUMBER = 7;
    private int usually1_;
    /**
     * <code>required int32 usually1 = 7;</code>
     */
    public boolean hasUsually1() {
      return ((bitField0_ & 0x00000040) == 0x00000040);
    }
    /**
     * <code>required int32 usually1 = 7;</code>
     */
    public int getUsually1() {
      return usually1_;
    }

    private void initFields() {
      name_ = "";
      firmware_ = "";
      build_ = "";
      usually21_ = 0;
      idk_ = com.google.protobuf.ByteString.EMPTY;
      usually22_ = 0;
      usually1_ = 0;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasName()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasFirmware()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasBuild()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasUsually21()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasIdk()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasUsually22()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasUsually1()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getNameBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, getFirmwareBytes());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeBytes(3, getBuildBytes());
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeInt32(4, usually21_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        output.writeBytes(5, idk_);
      }
      if (((bitField0_ & 0x00000020) == 0x00000020)) {
        output.writeInt32(6, usually22_);
      }
      if (((bitField0_ & 0x00000040) == 0x00000040)) {
        output.writeInt32(7, usually1_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getNameBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, getFirmwareBytes());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(3, getBuildBytes());
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(4, usually21_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(5, idk_);
      }
      if (((bitField0_ & 0x00000020) == 0x00000020)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(6, usually22_);
      }
      if (((bitField0_ & 0x00000040) == 0x00000040)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(7, usually1_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static Protobuf.BackupInfo parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Protobuf.BackupInfo parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Protobuf.BackupInfo parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Protobuf.BackupInfo parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Protobuf.BackupInfo parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static Protobuf.BackupInfo parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static Protobuf.BackupInfo parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static Protobuf.BackupInfo parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static Protobuf.BackupInfo parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static Protobuf.BackupInfo parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(Protobuf.BackupInfo prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code BackupInfo}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements Protobuf.BackupInfoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Protobuf.internal_static_BackupInfo_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Protobuf.internal_static_BackupInfo_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Protobuf.BackupInfo.class, Protobuf.BackupInfo.Builder.class);
      }

      // Construct using Protobuf.BackupInfo.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        name_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        firmware_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        build_ = "";
        bitField0_ = (bitField0_ & ~0x00000004);
        usually21_ = 0;
        bitField0_ = (bitField0_ & ~0x00000008);
        idk_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000010);
        usually22_ = 0;
        bitField0_ = (bitField0_ & ~0x00000020);
        usually1_ = 0;
        bitField0_ = (bitField0_ & ~0x00000040);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Protobuf.internal_static_BackupInfo_descriptor;
      }

      public Protobuf.BackupInfo getDefaultInstanceForType() {
        return Protobuf.BackupInfo.getDefaultInstance();
      }

      public Protobuf.BackupInfo build() {
        Protobuf.BackupInfo result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Protobuf.BackupInfo buildPartial() {
        Protobuf.BackupInfo result = new Protobuf.BackupInfo(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.name_ = name_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.firmware_ = firmware_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.build_ = build_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.usually21_ = usually21_;
        if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
          to_bitField0_ |= 0x00000010;
        }
        result.idk_ = idk_;
        if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
          to_bitField0_ |= 0x00000020;
        }
        result.usually22_ = usually22_;
        if (((from_bitField0_ & 0x00000040) == 0x00000040)) {
          to_bitField0_ |= 0x00000040;
        }
        result.usually1_ = usually1_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Protobuf.BackupInfo) {
          return mergeFrom((Protobuf.BackupInfo)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Protobuf.BackupInfo other) {
        if (other == Protobuf.BackupInfo.getDefaultInstance()) return this;
        if (other.hasName()) {
          bitField0_ |= 0x00000001;
          name_ = other.name_;
          onChanged();
        }
        if (other.hasFirmware()) {
          bitField0_ |= 0x00000002;
          firmware_ = other.firmware_;
          onChanged();
        }
        if (other.hasBuild()) {
          bitField0_ |= 0x00000004;
          build_ = other.build_;
          onChanged();
        }
        if (other.hasUsually21()) {
          setUsually21(other.getUsually21());
        }
        if (other.hasIdk()) {
          setIdk(other.getIdk());
        }
        if (other.hasUsually22()) {
          setUsually22(other.getUsually22());
        }
        if (other.hasUsually1()) {
          setUsually1(other.getUsually1());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasName()) {
          
          return false;
        }
        if (!hasFirmware()) {
          
          return false;
        }
        if (!hasBuild()) {
          
          return false;
        }
        if (!hasUsually21()) {
          
          return false;
        }
        if (!hasIdk()) {
          
          return false;
        }
        if (!hasUsually22()) {
          
          return false;
        }
        if (!hasUsually1()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Protobuf.BackupInfo parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Protobuf.BackupInfo) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required string name = 1;
      private java.lang.Object name_ = "";
      /**
       * <code>required string name = 1;</code>
       */
      public boolean hasName() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string name = 1;</code>
       */
      public java.lang.String getName() {
        java.lang.Object ref = name_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          name_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string name = 1;</code>
       */
      public com.google.protobuf.ByteString
          getNameBytes() {
        java.lang.Object ref = name_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          name_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string name = 1;</code>
       */
      public Builder setName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        name_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string name = 1;</code>
       */
      public Builder clearName() {
        bitField0_ = (bitField0_ & ~0x00000001);
        name_ = getDefaultInstance().getName();
        onChanged();
        return this;
      }
      /**
       * <code>required string name = 1;</code>
       */
      public Builder setNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        name_ = value;
        onChanged();
        return this;
      }

      // required string firmware = 2;
      private java.lang.Object firmware_ = "";
      /**
       * <code>required string firmware = 2;</code>
       */
      public boolean hasFirmware() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required string firmware = 2;</code>
       */
      public java.lang.String getFirmware() {
        java.lang.Object ref = firmware_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          firmware_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string firmware = 2;</code>
       */
      public com.google.protobuf.ByteString
          getFirmwareBytes() {
        java.lang.Object ref = firmware_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          firmware_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string firmware = 2;</code>
       */
      public Builder setFirmware(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        firmware_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string firmware = 2;</code>
       */
      public Builder clearFirmware() {
        bitField0_ = (bitField0_ & ~0x00000002);
        firmware_ = getDefaultInstance().getFirmware();
        onChanged();
        return this;
      }
      /**
       * <code>required string firmware = 2;</code>
       */
      public Builder setFirmwareBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        firmware_ = value;
        onChanged();
        return this;
      }

      // required string build = 3;
      private java.lang.Object build_ = "";
      /**
       * <code>required string build = 3;</code>
       */
      public boolean hasBuild() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>required string build = 3;</code>
       */
      public java.lang.String getBuild() {
        java.lang.Object ref = build_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          build_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string build = 3;</code>
       */
      public com.google.protobuf.ByteString
          getBuildBytes() {
        java.lang.Object ref = build_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          build_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string build = 3;</code>
       */
      public Builder setBuild(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        build_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string build = 3;</code>
       */
      public Builder clearBuild() {
        bitField0_ = (bitField0_ & ~0x00000004);
        build_ = getDefaultInstance().getBuild();
        onChanged();
        return this;
      }
      /**
       * <code>required string build = 3;</code>
       */
      public Builder setBuildBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        build_ = value;
        onChanged();
        return this;
      }

      // required int32 usually2_1 = 4;
      private int usually21_ ;
      /**
       * <code>required int32 usually2_1 = 4;</code>
       */
      public boolean hasUsually21() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>required int32 usually2_1 = 4;</code>
       */
      public int getUsually21() {
        return usually21_;
      }
      /**
       * <code>required int32 usually2_1 = 4;</code>
       */
      public Builder setUsually21(int value) {
        bitField0_ |= 0x00000008;
        usually21_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 usually2_1 = 4;</code>
       */
      public Builder clearUsually21() {
        bitField0_ = (bitField0_ & ~0x00000008);
        usually21_ = 0;
        onChanged();
        return this;
      }

      // required bytes idk = 5;
      private com.google.protobuf.ByteString idk_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>required bytes idk = 5;</code>
       */
      public boolean hasIdk() {
        return ((bitField0_ & 0x00000010) == 0x00000010);
      }
      /**
       * <code>required bytes idk = 5;</code>
       */
      public com.google.protobuf.ByteString getIdk() {
        return idk_;
      }
      /**
       * <code>required bytes idk = 5;</code>
       */
      public Builder setIdk(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000010;
        idk_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required bytes idk = 5;</code>
       */
      public Builder clearIdk() {
        bitField0_ = (bitField0_ & ~0x00000010);
        idk_ = getDefaultInstance().getIdk();
        onChanged();
        return this;
      }

      // required int32 usually2_2 = 6;
      private int usually22_ ;
      /**
       * <code>required int32 usually2_2 = 6;</code>
       */
      public boolean hasUsually22() {
        return ((bitField0_ & 0x00000020) == 0x00000020);
      }
      /**
       * <code>required int32 usually2_2 = 6;</code>
       */
      public int getUsually22() {
        return usually22_;
      }
      /**
       * <code>required int32 usually2_2 = 6;</code>
       */
      public Builder setUsually22(int value) {
        bitField0_ |= 0x00000020;
        usually22_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 usually2_2 = 6;</code>
       */
      public Builder clearUsually22() {
        bitField0_ = (bitField0_ & ~0x00000020);
        usually22_ = 0;
        onChanged();
        return this;
      }

      // required int32 usually1 = 7;
      private int usually1_ ;
      /**
       * <code>required int32 usually1 = 7;</code>
       */
      public boolean hasUsually1() {
        return ((bitField0_ & 0x00000040) == 0x00000040);
      }
      /**
       * <code>required int32 usually1 = 7;</code>
       */
      public int getUsually1() {
        return usually1_;
      }
      /**
       * <code>required int32 usually1 = 7;</code>
       */
      public Builder setUsually1(int value) {
        bitField0_ |= 0x00000040;
        usually1_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 usually1 = 7;</code>
       */
      public Builder clearUsually1() {
        bitField0_ = (bitField0_ & ~0x00000040);
        usually1_ = 0;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:BackupInfo)
    }

    static {
      defaultInstance = new BackupInfo(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:BackupInfo)
  }

  public interface DeviceInfoOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required string shortName = 1;
    /**
     * <code>required string shortName = 1;</code>
     */
    boolean hasShortName();
    /**
     * <code>required string shortName = 1;</code>
     */
    java.lang.String getShortName();
    /**
     * <code>required string shortName = 1;</code>
     */
    com.google.protobuf.ByteString
        getShortNameBytes();

    // required string realName = 2;
    /**
     * <code>required string realName = 2;</code>
     */
    boolean hasRealName();
    /**
     * <code>required string realName = 2;</code>
     */
    java.lang.String getRealName();
    /**
     * <code>required string realName = 2;</code>
     */
    com.google.protobuf.ByteString
        getRealNameBytes();

    // required string serial = 3;
    /**
     * <code>required string serial = 3;</code>
     */
    boolean hasSerial();
    /**
     * <code>required string serial = 3;</code>
     */
    java.lang.String getSerial();
    /**
     * <code>required string serial = 3;</code>
     */
    com.google.protobuf.ByteString
        getSerialBytes();

    // required string color = 4;
    /**
     * <code>required string color = 4;</code>
     */
    boolean hasColor();
    /**
     * <code>required string color = 4;</code>
     */
    java.lang.String getColor();
    /**
     * <code>required string color = 4;</code>
     */
    com.google.protobuf.ByteString
        getColorBytes();

    // required string model = 5;
    /**
     * <code>required string model = 5;</code>
     */
    boolean hasModel();
    /**
     * <code>required string model = 5;</code>
     */
    java.lang.String getModel();
    /**
     * <code>required string model = 5;</code>
     */
    com.google.protobuf.ByteString
        getModelBytes();

    // required string prettyName = 6;
    /**
     * <code>required string prettyName = 6;</code>
     */
    boolean hasPrettyName();
    /**
     * <code>required string prettyName = 6;</code>
     */
    java.lang.String getPrettyName();
    /**
     * <code>required string prettyName = 6;</code>
     */
    com.google.protobuf.ByteString
        getPrettyNameBytes();

    // optional string idk = 7;
    /**
     * <code>optional string idk = 7;</code>
     */
    boolean hasIdk();
    /**
     * <code>optional string idk = 7;</code>
     */
    java.lang.String getIdk();
    /**
     * <code>optional string idk = 7;</code>
     */
    com.google.protobuf.ByteString
        getIdkBytes();
  }
  /**
   * Protobuf type {@code DeviceInfo}
   */
  public static final class DeviceInfo extends
      com.google.protobuf.GeneratedMessage
      implements DeviceInfoOrBuilder {
    // Use DeviceInfo.newBuilder() to construct.
    private DeviceInfo(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private DeviceInfo(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final DeviceInfo defaultInstance;
    public static DeviceInfo getDefaultInstance() {
      return defaultInstance;
    }

    public DeviceInfo getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private DeviceInfo(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              bitField0_ |= 0x00000001;
              shortName_ = input.readBytes();
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              realName_ = input.readBytes();
              break;
            }
            case 26: {
              bitField0_ |= 0x00000004;
              serial_ = input.readBytes();
              break;
            }
            case 34: {
              bitField0_ |= 0x00000008;
              color_ = input.readBytes();
              break;
            }
            case 42: {
              bitField0_ |= 0x00000010;
              model_ = input.readBytes();
              break;
            }
            case 50: {
              bitField0_ |= 0x00000020;
              prettyName_ = input.readBytes();
              break;
            }
            case 58: {
              bitField0_ |= 0x00000040;
              idk_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Protobuf.internal_static_DeviceInfo_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Protobuf.internal_static_DeviceInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Protobuf.DeviceInfo.class, Protobuf.DeviceInfo.Builder.class);
    }

    public static com.google.protobuf.Parser<DeviceInfo> PARSER =
        new com.google.protobuf.AbstractParser<DeviceInfo>() {
      public DeviceInfo parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new DeviceInfo(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<DeviceInfo> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required string shortName = 1;
    public static final int SHORTNAME_FIELD_NUMBER = 1;
    private java.lang.Object shortName_;
    /**
     * <code>required string shortName = 1;</code>
     */
    public boolean hasShortName() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string shortName = 1;</code>
     */
    public java.lang.String getShortName() {
      java.lang.Object ref = shortName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          shortName_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string shortName = 1;</code>
     */
    public com.google.protobuf.ByteString
        getShortNameBytes() {
      java.lang.Object ref = shortName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        shortName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // required string realName = 2;
    public static final int REALNAME_FIELD_NUMBER = 2;
    private java.lang.Object realName_;
    /**
     * <code>required string realName = 2;</code>
     */
    public boolean hasRealName() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string realName = 2;</code>
     */
    public java.lang.String getRealName() {
      java.lang.Object ref = realName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          realName_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string realName = 2;</code>
     */
    public com.google.protobuf.ByteString
        getRealNameBytes() {
      java.lang.Object ref = realName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        realName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // required string serial = 3;
    public static final int SERIAL_FIELD_NUMBER = 3;
    private java.lang.Object serial_;
    /**
     * <code>required string serial = 3;</code>
     */
    public boolean hasSerial() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required string serial = 3;</code>
     */
    public java.lang.String getSerial() {
      java.lang.Object ref = serial_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          serial_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string serial = 3;</code>
     */
    public com.google.protobuf.ByteString
        getSerialBytes() {
      java.lang.Object ref = serial_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        serial_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // required string color = 4;
    public static final int COLOR_FIELD_NUMBER = 4;
    private java.lang.Object color_;
    /**
     * <code>required string color = 4;</code>
     */
    public boolean hasColor() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>required string color = 4;</code>
     */
    public java.lang.String getColor() {
      java.lang.Object ref = color_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          color_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string color = 4;</code>
     */
    public com.google.protobuf.ByteString
        getColorBytes() {
      java.lang.Object ref = color_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        color_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // required string model = 5;
    public static final int MODEL_FIELD_NUMBER = 5;
    private java.lang.Object model_;
    /**
     * <code>required string model = 5;</code>
     */
    public boolean hasModel() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>required string model = 5;</code>
     */
    public java.lang.String getModel() {
      java.lang.Object ref = model_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          model_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string model = 5;</code>
     */
    public com.google.protobuf.ByteString
        getModelBytes() {
      java.lang.Object ref = model_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        model_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // required string prettyName = 6;
    public static final int PRETTYNAME_FIELD_NUMBER = 6;
    private java.lang.Object prettyName_;
    /**
     * <code>required string prettyName = 6;</code>
     */
    public boolean hasPrettyName() {
      return ((bitField0_ & 0x00000020) == 0x00000020);
    }
    /**
     * <code>required string prettyName = 6;</code>
     */
    public java.lang.String getPrettyName() {
      java.lang.Object ref = prettyName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          prettyName_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string prettyName = 6;</code>
     */
    public com.google.protobuf.ByteString
        getPrettyNameBytes() {
      java.lang.Object ref = prettyName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        prettyName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // optional string idk = 7;
    public static final int IDK_FIELD_NUMBER = 7;
    private java.lang.Object idk_;
    /**
     * <code>optional string idk = 7;</code>
     */
    public boolean hasIdk() {
      return ((bitField0_ & 0x00000040) == 0x00000040);
    }
    /**
     * <code>optional string idk = 7;</code>
     */
    public java.lang.String getIdk() {
      java.lang.Object ref = idk_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          idk_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string idk = 7;</code>
     */
    public com.google.protobuf.ByteString
        getIdkBytes() {
      java.lang.Object ref = idk_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        idk_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private void initFields() {
      shortName_ = "";
      realName_ = "";
      serial_ = "";
      color_ = "";
      model_ = "";
      prettyName_ = "";
      idk_ = "";
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasShortName()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasRealName()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasSerial()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasColor()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasModel()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasPrettyName()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getShortNameBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, getRealNameBytes());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeBytes(3, getSerialBytes());
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeBytes(4, getColorBytes());
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        output.writeBytes(5, getModelBytes());
      }
      if (((bitField0_ & 0x00000020) == 0x00000020)) {
        output.writeBytes(6, getPrettyNameBytes());
      }
      if (((bitField0_ & 0x00000040) == 0x00000040)) {
        output.writeBytes(7, getIdkBytes());
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getShortNameBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, getRealNameBytes());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(3, getSerialBytes());
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(4, getColorBytes());
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(5, getModelBytes());
      }
      if (((bitField0_ & 0x00000020) == 0x00000020)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(6, getPrettyNameBytes());
      }
      if (((bitField0_ & 0x00000040) == 0x00000040)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(7, getIdkBytes());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static Protobuf.DeviceInfo parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Protobuf.DeviceInfo parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Protobuf.DeviceInfo parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Protobuf.DeviceInfo parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Protobuf.DeviceInfo parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static Protobuf.DeviceInfo parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static Protobuf.DeviceInfo parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static Protobuf.DeviceInfo parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static Protobuf.DeviceInfo parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static Protobuf.DeviceInfo parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(Protobuf.DeviceInfo prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code DeviceInfo}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements Protobuf.DeviceInfoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Protobuf.internal_static_DeviceInfo_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Protobuf.internal_static_DeviceInfo_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Protobuf.DeviceInfo.class, Protobuf.DeviceInfo.Builder.class);
      }

      // Construct using Protobuf.DeviceInfo.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        shortName_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        realName_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        serial_ = "";
        bitField0_ = (bitField0_ & ~0x00000004);
        color_ = "";
        bitField0_ = (bitField0_ & ~0x00000008);
        model_ = "";
        bitField0_ = (bitField0_ & ~0x00000010);
        prettyName_ = "";
        bitField0_ = (bitField0_ & ~0x00000020);
        idk_ = "";
        bitField0_ = (bitField0_ & ~0x00000040);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Protobuf.internal_static_DeviceInfo_descriptor;
      }

      public Protobuf.DeviceInfo getDefaultInstanceForType() {
        return Protobuf.DeviceInfo.getDefaultInstance();
      }

      public Protobuf.DeviceInfo build() {
        Protobuf.DeviceInfo result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Protobuf.DeviceInfo buildPartial() {
        Protobuf.DeviceInfo result = new Protobuf.DeviceInfo(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.shortName_ = shortName_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.realName_ = realName_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.serial_ = serial_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.color_ = color_;
        if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
          to_bitField0_ |= 0x00000010;
        }
        result.model_ = model_;
        if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
          to_bitField0_ |= 0x00000020;
        }
        result.prettyName_ = prettyName_;
        if (((from_bitField0_ & 0x00000040) == 0x00000040)) {
          to_bitField0_ |= 0x00000040;
        }
        result.idk_ = idk_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Protobuf.DeviceInfo) {
          return mergeFrom((Protobuf.DeviceInfo)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Protobuf.DeviceInfo other) {
        if (other == Protobuf.DeviceInfo.getDefaultInstance()) return this;
        if (other.hasShortName()) {
          bitField0_ |= 0x00000001;
          shortName_ = other.shortName_;
          onChanged();
        }
        if (other.hasRealName()) {
          bitField0_ |= 0x00000002;
          realName_ = other.realName_;
          onChanged();
        }
        if (other.hasSerial()) {
          bitField0_ |= 0x00000004;
          serial_ = other.serial_;
          onChanged();
        }
        if (other.hasColor()) {
          bitField0_ |= 0x00000008;
          color_ = other.color_;
          onChanged();
        }
        if (other.hasModel()) {
          bitField0_ |= 0x00000010;
          model_ = other.model_;
          onChanged();
        }
        if (other.hasPrettyName()) {
          bitField0_ |= 0x00000020;
          prettyName_ = other.prettyName_;
          onChanged();
        }
        if (other.hasIdk()) {
          bitField0_ |= 0x00000040;
          idk_ = other.idk_;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasShortName()) {
          
          return false;
        }
        if (!hasRealName()) {
          
          return false;
        }
        if (!hasSerial()) {
          
          return false;
        }
        if (!hasColor()) {
          
          return false;
        }
        if (!hasModel()) {
          
          return false;
        }
        if (!hasPrettyName()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Protobuf.DeviceInfo parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Protobuf.DeviceInfo) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required string shortName = 1;
      private java.lang.Object shortName_ = "";
      /**
       * <code>required string shortName = 1;</code>
       */
      public boolean hasShortName() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string shortName = 1;</code>
       */
      public java.lang.String getShortName() {
        java.lang.Object ref = shortName_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          shortName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string shortName = 1;</code>
       */
      public com.google.protobuf.ByteString
          getShortNameBytes() {
        java.lang.Object ref = shortName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          shortName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string shortName = 1;</code>
       */
      public Builder setShortName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        shortName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string shortName = 1;</code>
       */
      public Builder clearShortName() {
        bitField0_ = (bitField0_ & ~0x00000001);
        shortName_ = getDefaultInstance().getShortName();
        onChanged();
        return this;
      }
      /**
       * <code>required string shortName = 1;</code>
       */
      public Builder setShortNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        shortName_ = value;
        onChanged();
        return this;
      }

      // required string realName = 2;
      private java.lang.Object realName_ = "";
      /**
       * <code>required string realName = 2;</code>
       */
      public boolean hasRealName() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required string realName = 2;</code>
       */
      public java.lang.String getRealName() {
        java.lang.Object ref = realName_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          realName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string realName = 2;</code>
       */
      public com.google.protobuf.ByteString
          getRealNameBytes() {
        java.lang.Object ref = realName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          realName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string realName = 2;</code>
       */
      public Builder setRealName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        realName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string realName = 2;</code>
       */
      public Builder clearRealName() {
        bitField0_ = (bitField0_ & ~0x00000002);
        realName_ = getDefaultInstance().getRealName();
        onChanged();
        return this;
      }
      /**
       * <code>required string realName = 2;</code>
       */
      public Builder setRealNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        realName_ = value;
        onChanged();
        return this;
      }

      // required string serial = 3;
      private java.lang.Object serial_ = "";
      /**
       * <code>required string serial = 3;</code>
       */
      public boolean hasSerial() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>required string serial = 3;</code>
       */
      public java.lang.String getSerial() {
        java.lang.Object ref = serial_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          serial_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string serial = 3;</code>
       */
      public com.google.protobuf.ByteString
          getSerialBytes() {
        java.lang.Object ref = serial_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          serial_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string serial = 3;</code>
       */
      public Builder setSerial(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        serial_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string serial = 3;</code>
       */
      public Builder clearSerial() {
        bitField0_ = (bitField0_ & ~0x00000004);
        serial_ = getDefaultInstance().getSerial();
        onChanged();
        return this;
      }
      /**
       * <code>required string serial = 3;</code>
       */
      public Builder setSerialBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        serial_ = value;
        onChanged();
        return this;
      }

      // required string color = 4;
      private java.lang.Object color_ = "";
      /**
       * <code>required string color = 4;</code>
       */
      public boolean hasColor() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>required string color = 4;</code>
       */
      public java.lang.String getColor() {
        java.lang.Object ref = color_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          color_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string color = 4;</code>
       */
      public com.google.protobuf.ByteString
          getColorBytes() {
        java.lang.Object ref = color_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          color_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string color = 4;</code>
       */
      public Builder setColor(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
        color_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string color = 4;</code>
       */
      public Builder clearColor() {
        bitField0_ = (bitField0_ & ~0x00000008);
        color_ = getDefaultInstance().getColor();
        onChanged();
        return this;
      }
      /**
       * <code>required string color = 4;</code>
       */
      public Builder setColorBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
        color_ = value;
        onChanged();
        return this;
      }

      // required string model = 5;
      private java.lang.Object model_ = "";
      /**
       * <code>required string model = 5;</code>
       */
      public boolean hasModel() {
        return ((bitField0_ & 0x00000010) == 0x00000010);
      }
      /**
       * <code>required string model = 5;</code>
       */
      public java.lang.String getModel() {
        java.lang.Object ref = model_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          model_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string model = 5;</code>
       */
      public com.google.protobuf.ByteString
          getModelBytes() {
        java.lang.Object ref = model_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          model_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string model = 5;</code>
       */
      public Builder setModel(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000010;
        model_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string model = 5;</code>
       */
      public Builder clearModel() {
        bitField0_ = (bitField0_ & ~0x00000010);
        model_ = getDefaultInstance().getModel();
        onChanged();
        return this;
      }
      /**
       * <code>required string model = 5;</code>
       */
      public Builder setModelBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000010;
        model_ = value;
        onChanged();
        return this;
      }

      // required string prettyName = 6;
      private java.lang.Object prettyName_ = "";
      /**
       * <code>required string prettyName = 6;</code>
       */
      public boolean hasPrettyName() {
        return ((bitField0_ & 0x00000020) == 0x00000020);
      }
      /**
       * <code>required string prettyName = 6;</code>
       */
      public java.lang.String getPrettyName() {
        java.lang.Object ref = prettyName_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          prettyName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string prettyName = 6;</code>
       */
      public com.google.protobuf.ByteString
          getPrettyNameBytes() {
        java.lang.Object ref = prettyName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          prettyName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string prettyName = 6;</code>
       */
      public Builder setPrettyName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000020;
        prettyName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string prettyName = 6;</code>
       */
      public Builder clearPrettyName() {
        bitField0_ = (bitField0_ & ~0x00000020);
        prettyName_ = getDefaultInstance().getPrettyName();
        onChanged();
        return this;
      }
      /**
       * <code>required string prettyName = 6;</code>
       */
      public Builder setPrettyNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000020;
        prettyName_ = value;
        onChanged();
        return this;
      }

      // optional string idk = 7;
      private java.lang.Object idk_ = "";
      /**
       * <code>optional string idk = 7;</code>
       */
      public boolean hasIdk() {
        return ((bitField0_ & 0x00000040) == 0x00000040);
      }
      /**
       * <code>optional string idk = 7;</code>
       */
      public java.lang.String getIdk() {
        java.lang.Object ref = idk_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          idk_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string idk = 7;</code>
       */
      public com.google.protobuf.ByteString
          getIdkBytes() {
        java.lang.Object ref = idk_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          idk_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string idk = 7;</code>
       */
      public Builder setIdk(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000040;
        idk_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string idk = 7;</code>
       */
      public Builder clearIdk() {
        bitField0_ = (bitField0_ & ~0x00000040);
        idk_ = getDefaultInstance().getIdk();
        onChanged();
        return this;
      }
      /**
       * <code>optional string idk = 7;</code>
       */
      public Builder setIdkBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000040;
        idk_ = value;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:DeviceInfo)
    }

    static {
      defaultInstance = new DeviceInfo(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:DeviceInfo)
  }

  public interface KeysOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // repeated .Key keySet = 1;
    /**
     * <code>repeated .Key keySet = 1;</code>
     */
    java.util.List<Protobuf.Key> 
        getKeySetList();
    /**
     * <code>repeated .Key keySet = 1;</code>
     */
    Protobuf.Key getKeySet(int index);
    /**
     * <code>repeated .Key keySet = 1;</code>
     */
    int getKeySetCount();
    /**
     * <code>repeated .Key keySet = 1;</code>
     */
    java.util.List<? extends Protobuf.KeyOrBuilder> 
        getKeySetOrBuilderList();
    /**
     * <code>repeated .Key keySet = 1;</code>
     */
    Protobuf.KeyOrBuilder getKeySetOrBuilder(
        int index);
  }
  /**
   * Protobuf type {@code Keys}
   */
  public static final class Keys extends
      com.google.protobuf.GeneratedMessage
      implements KeysOrBuilder {
    // Use Keys.newBuilder() to construct.
    private Keys(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private Keys(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final Keys defaultInstance;
    public static Keys getDefaultInstance() {
      return defaultInstance;
    }

    public Keys getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private Keys(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                keySet_ = new java.util.ArrayList<Protobuf.Key>();
                mutable_bitField0_ |= 0x00000001;
              }
              keySet_.add(input.readMessage(Protobuf.Key.PARSER, extensionRegistry));
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
          keySet_ = java.util.Collections.unmodifiableList(keySet_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Protobuf.internal_static_Keys_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Protobuf.internal_static_Keys_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Protobuf.Keys.class, Protobuf.Keys.Builder.class);
    }

    public static com.google.protobuf.Parser<Keys> PARSER =
        new com.google.protobuf.AbstractParser<Keys>() {
      public Keys parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Keys(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<Keys> getParserForType() {
      return PARSER;
    }

    // repeated .Key keySet = 1;
    public static final int KEYSET_FIELD_NUMBER = 1;
    private java.util.List<Protobuf.Key> keySet_;
    /**
     * <code>repeated .Key keySet = 1;</code>
     */
    public java.util.List<Protobuf.Key> getKeySetList() {
      return keySet_;
    }
    /**
     * <code>repeated .Key keySet = 1;</code>
     */
    public java.util.List<? extends Protobuf.KeyOrBuilder> 
        getKeySetOrBuilderList() {
      return keySet_;
    }
    /**
     * <code>repeated .Key keySet = 1;</code>
     */
    public int getKeySetCount() {
      return keySet_.size();
    }
    /**
     * <code>repeated .Key keySet = 1;</code>
     */
    public Protobuf.Key getKeySet(int index) {
      return keySet_.get(index);
    }
    /**
     * <code>repeated .Key keySet = 1;</code>
     */
    public Protobuf.KeyOrBuilder getKeySetOrBuilder(
        int index) {
      return keySet_.get(index);
    }

    private void initFields() {
      keySet_ = java.util.Collections.emptyList();
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      for (int i = 0; i < getKeySetCount(); i++) {
        if (!getKeySet(i).isInitialized()) {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      for (int i = 0; i < keySet_.size(); i++) {
        output.writeMessage(1, keySet_.get(i));
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      for (int i = 0; i < keySet_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, keySet_.get(i));
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static Protobuf.Keys parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Protobuf.Keys parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Protobuf.Keys parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Protobuf.Keys parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Protobuf.Keys parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static Protobuf.Keys parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static Protobuf.Keys parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static Protobuf.Keys parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static Protobuf.Keys parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static Protobuf.Keys parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(Protobuf.Keys prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Keys}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements Protobuf.KeysOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Protobuf.internal_static_Keys_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Protobuf.internal_static_Keys_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Protobuf.Keys.class, Protobuf.Keys.Builder.class);
      }

      // Construct using Protobuf.Keys.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
          getKeySetFieldBuilder();
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        if (keySetBuilder_ == null) {
          keySet_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          keySetBuilder_.clear();
        }
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Protobuf.internal_static_Keys_descriptor;
      }

      public Protobuf.Keys getDefaultInstanceForType() {
        return Protobuf.Keys.getDefaultInstance();
      }

      public Protobuf.Keys build() {
        Protobuf.Keys result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Protobuf.Keys buildPartial() {
        Protobuf.Keys result = new Protobuf.Keys(this);
        int from_bitField0_ = bitField0_;
        if (keySetBuilder_ == null) {
          if (((bitField0_ & 0x00000001) == 0x00000001)) {
            keySet_ = java.util.Collections.unmodifiableList(keySet_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.keySet_ = keySet_;
        } else {
          result.keySet_ = keySetBuilder_.build();
        }
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Protobuf.Keys) {
          return mergeFrom((Protobuf.Keys)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Protobuf.Keys other) {
        if (other == Protobuf.Keys.getDefaultInstance()) return this;
        if (keySetBuilder_ == null) {
          if (!other.keySet_.isEmpty()) {
            if (keySet_.isEmpty()) {
              keySet_ = other.keySet_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureKeySetIsMutable();
              keySet_.addAll(other.keySet_);
            }
            onChanged();
          }
        } else {
          if (!other.keySet_.isEmpty()) {
            if (keySetBuilder_.isEmpty()) {
              keySetBuilder_.dispose();
              keySetBuilder_ = null;
              keySet_ = other.keySet_;
              bitField0_ = (bitField0_ & ~0x00000001);
              keySetBuilder_ = 
                com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ?
                   getKeySetFieldBuilder() : null;
            } else {
              keySetBuilder_.addAllMessages(other.keySet_);
            }
          }
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        for (int i = 0; i < getKeySetCount(); i++) {
          if (!getKeySet(i).isInitialized()) {
            
            return false;
          }
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Protobuf.Keys parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Protobuf.Keys) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // repeated .Key keySet = 1;
      private java.util.List<Protobuf.Key> keySet_ =
        java.util.Collections.emptyList();
      private void ensureKeySetIsMutable() {
        if (!((bitField0_ & 0x00000001) == 0x00000001)) {
          keySet_ = new java.util.ArrayList<Protobuf.Key>(keySet_);
          bitField0_ |= 0x00000001;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilder<
          Protobuf.Key, Protobuf.Key.Builder, Protobuf.KeyOrBuilder> keySetBuilder_;

      /**
       * <code>repeated .Key keySet = 1;</code>
       */
      public java.util.List<Protobuf.Key> getKeySetList() {
        if (keySetBuilder_ == null) {
          return java.util.Collections.unmodifiableList(keySet_);
        } else {
          return keySetBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .Key keySet = 1;</code>
       */
      public int getKeySetCount() {
        if (keySetBuilder_ == null) {
          return keySet_.size();
        } else {
          return keySetBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .Key keySet = 1;</code>
       */
      public Protobuf.Key getKeySet(int index) {
        if (keySetBuilder_ == null) {
          return keySet_.get(index);
        } else {
          return keySetBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .Key keySet = 1;</code>
       */
      public Builder setKeySet(
          int index, Protobuf.Key value) {
        if (keySetBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureKeySetIsMutable();
          keySet_.set(index, value);
          onChanged();
        } else {
          keySetBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .Key keySet = 1;</code>
       */
      public Builder setKeySet(
          int index, Protobuf.Key.Builder builderForValue) {
        if (keySetBuilder_ == null) {
          ensureKeySetIsMutable();
          keySet_.set(index, builderForValue.build());
          onChanged();
        } else {
          keySetBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Key keySet = 1;</code>
       */
      public Builder addKeySet(Protobuf.Key value) {
        if (keySetBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureKeySetIsMutable();
          keySet_.add(value);
          onChanged();
        } else {
          keySetBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .Key keySet = 1;</code>
       */
      public Builder addKeySet(
          int index, Protobuf.Key value) {
        if (keySetBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureKeySetIsMutable();
          keySet_.add(index, value);
          onChanged();
        } else {
          keySetBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .Key keySet = 1;</code>
       */
      public Builder addKeySet(
          Protobuf.Key.Builder builderForValue) {
        if (keySetBuilder_ == null) {
          ensureKeySetIsMutable();
          keySet_.add(builderForValue.build());
          onChanged();
        } else {
          keySetBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Key keySet = 1;</code>
       */
      public Builder addKeySet(
          int index, Protobuf.Key.Builder builderForValue) {
        if (keySetBuilder_ == null) {
          ensureKeySetIsMutable();
          keySet_.add(index, builderForValue.build());
          onChanged();
        } else {
          keySetBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .Key keySet = 1;</code>
       */
      public Builder addAllKeySet(
          java.lang.Iterable<? extends Protobuf.Key> values) {
        if (keySetBuilder_ == null) {
          ensureKeySetIsMutable();
          super.addAll(values, keySet_);
          onChanged();
        } else {
          keySetBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .Key keySet = 1;</code>
       */
      public Builder clearKeySet() {
        if (keySetBuilder_ == null) {
          keySet_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          keySetBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .Key keySet = 1;</code>
       */
      public Builder removeKeySet(int index) {
        if (keySetBuilder_ == null) {
          ensureKeySetIsMutable();
          keySet_.remove(index);
          onChanged();
        } else {
          keySetBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .Key keySet = 1;</code>
       */
      public Protobuf.Key.Builder getKeySetBuilder(
          int index) {
        return getKeySetFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .Key keySet = 1;</code>
       */
      public Protobuf.KeyOrBuilder getKeySetOrBuilder(
          int index) {
        if (keySetBuilder_ == null) {
          return keySet_.get(index);  } else {
          return keySetBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .Key keySet = 1;</code>
       */
      public java.util.List<? extends Protobuf.KeyOrBuilder> 
           getKeySetOrBuilderList() {
        if (keySetBuilder_ != null) {
          return keySetBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(keySet_);
        }
      }
      /**
       * <code>repeated .Key keySet = 1;</code>
       */
      public Protobuf.Key.Builder addKeySetBuilder() {
        return getKeySetFieldBuilder().addBuilder(
            Protobuf.Key.getDefaultInstance());
      }
      /**
       * <code>repeated .Key keySet = 1;</code>
       */
      public Protobuf.Key.Builder addKeySetBuilder(
          int index) {
        return getKeySetFieldBuilder().addBuilder(
            index, Protobuf.Key.getDefaultInstance());
      }
      /**
       * <code>repeated .Key keySet = 1;</code>
       */
      public java.util.List<Protobuf.Key.Builder> 
           getKeySetBuilderList() {
        return getKeySetFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilder<
          Protobuf.Key, Protobuf.Key.Builder, Protobuf.KeyOrBuilder> 
          getKeySetFieldBuilder() {
        if (keySetBuilder_ == null) {
          keySetBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
              Protobuf.Key, Protobuf.Key.Builder, Protobuf.KeyOrBuilder>(
                  keySet_,
                  ((bitField0_ & 0x00000001) == 0x00000001),
                  getParentForChildren(),
                  isClean());
          keySet_ = null;
        }
        return keySetBuilder_;
      }

      // @@protoc_insertion_point(builder_scope:Keys)
    }

    static {
      defaultInstance = new Keys(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:Keys)
  }

  public interface KeyOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required int32 index = 1;
    /**
     * <code>required int32 index = 1;</code>
     */
    boolean hasIndex();
    /**
     * <code>required int32 index = 1;</code>
     */
    int getIndex();

    // required string data = 2;
    /**
     * <code>required string data = 2;</code>
     */
    boolean hasData();
    /**
     * <code>required string data = 2;</code>
     */
    java.lang.String getData();
    /**
     * <code>required string data = 2;</code>
     */
    com.google.protobuf.ByteString
        getDataBytes();
  }
  /**
   * Protobuf type {@code Key}
   */
  public static final class Key extends
      com.google.protobuf.GeneratedMessage
      implements KeyOrBuilder {
    // Use Key.newBuilder() to construct.
    private Key(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private Key(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final Key defaultInstance;
    public static Key getDefaultInstance() {
      return defaultInstance;
    }

    public Key getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private Key(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              index_ = input.readInt32();
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              data_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Protobuf.internal_static_Key_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Protobuf.internal_static_Key_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Protobuf.Key.class, Protobuf.Key.Builder.class);
    }

    public static com.google.protobuf.Parser<Key> PARSER =
        new com.google.protobuf.AbstractParser<Key>() {
      public Key parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Key(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<Key> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required int32 index = 1;
    public static final int INDEX_FIELD_NUMBER = 1;
    private int index_;
    /**
     * <code>required int32 index = 1;</code>
     */
    public boolean hasIndex() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required int32 index = 1;</code>
     */
    public int getIndex() {
      return index_;
    }

    // required string data = 2;
    public static final int DATA_FIELD_NUMBER = 2;
    private java.lang.Object data_;
    /**
     * <code>required string data = 2;</code>
     */
    public boolean hasData() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string data = 2;</code>
     */
    public java.lang.String getData() {
      java.lang.Object ref = data_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          data_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string data = 2;</code>
     */
    public com.google.protobuf.ByteString
        getDataBytes() {
      java.lang.Object ref = data_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        data_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private void initFields() {
      index_ = 0;
      data_ = "";
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasIndex()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasData()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt32(1, index_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, getDataBytes());
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, index_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, getDataBytes());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static Protobuf.Key parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Protobuf.Key parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Protobuf.Key parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Protobuf.Key parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Protobuf.Key parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static Protobuf.Key parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static Protobuf.Key parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static Protobuf.Key parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static Protobuf.Key parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static Protobuf.Key parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(Protobuf.Key prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Key}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements Protobuf.KeyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Protobuf.internal_static_Key_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Protobuf.internal_static_Key_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Protobuf.Key.class, Protobuf.Key.Builder.class);
      }

      // Construct using Protobuf.Key.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        index_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        data_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Protobuf.internal_static_Key_descriptor;
      }

      public Protobuf.Key getDefaultInstanceForType() {
        return Protobuf.Key.getDefaultInstance();
      }

      public Protobuf.Key build() {
        Protobuf.Key result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Protobuf.Key buildPartial() {
        Protobuf.Key result = new Protobuf.Key(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.index_ = index_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.data_ = data_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Protobuf.Key) {
          return mergeFrom((Protobuf.Key)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Protobuf.Key other) {
        if (other == Protobuf.Key.getDefaultInstance()) return this;
        if (other.hasIndex()) {
          setIndex(other.getIndex());
        }
        if (other.hasData()) {
          bitField0_ |= 0x00000002;
          data_ = other.data_;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasIndex()) {
          
          return false;
        }
        if (!hasData()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Protobuf.Key parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Protobuf.Key) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required int32 index = 1;
      private int index_ ;
      /**
       * <code>required int32 index = 1;</code>
       */
      public boolean hasIndex() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required int32 index = 1;</code>
       */
      public int getIndex() {
        return index_;
      }
      /**
       * <code>required int32 index = 1;</code>
       */
      public Builder setIndex(int value) {
        bitField0_ |= 0x00000001;
        index_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 index = 1;</code>
       */
      public Builder clearIndex() {
        bitField0_ = (bitField0_ & ~0x00000001);
        index_ = 0;
        onChanged();
        return this;
      }

      // required string data = 2;
      private java.lang.Object data_ = "";
      /**
       * <code>required string data = 2;</code>
       */
      public boolean hasData() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required string data = 2;</code>
       */
      public java.lang.String getData() {
        java.lang.Object ref = data_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          data_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string data = 2;</code>
       */
      public com.google.protobuf.ByteString
          getDataBytes() {
        java.lang.Object ref = data_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          data_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string data = 2;</code>
       */
      public Builder setData(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        data_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string data = 2;</code>
       */
      public Builder clearData() {
        bitField0_ = (bitField0_ & ~0x00000002);
        data_ = getDefaultInstance().getData();
        onChanged();
        return this;
      }
      /**
       * <code>required string data = 2;</code>
       */
      public Builder setDataBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        data_ = value;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:Key)
    }

    static {
      defaultInstance = new Key(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:Key)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_DeviceUdids_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_DeviceUdids_fieldAccessorTable;
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_Device_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Device_fieldAccessorTable;
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_Backup_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Backup_fieldAccessorTable;
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_BackupInfo_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_BackupInfo_fieldAccessorTable;
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_DeviceInfo_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_DeviceInfo_fieldAccessorTable;
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_Keys_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Keys_fieldAccessorTable;
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_Key_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Key_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016protobuf.proto\"@\n\013DeviceUdids\022\014\n\004psid\030" +
      "\001 \002(\t\022\r\n\005udids\030\002 \003(\014\022\024\n\014usuallyFalse\030\003 \001" +
      "(\010\"l\n\006Device\022\014\n\004udid\030\001 \002(\014\022\020\n\010fullSize\030\002" +
      " \002(\003\022\027\n\006backup\030\003 \003(\0132\007.Backup\022\033\n\006device\030" +
      "\004 \002(\0132\013.DeviceInfo\022\014\n\004time\030\005 \002(\003\"c\n\006Back" +
      "up\022\022\n\nsnapshotID\030\001 \002(\005\022\014\n\004size\030\002 \002(\003\022\r\n\005" +
      "time1\030\003 \002(\003\022\031\n\004info\030\005 \002(\0132\013.BackupInfo\022\r" +
      "\n\005time2\030\006 \002(\003\"\202\001\n\nBackupInfo\022\014\n\004name\030\001 \002" +
      "(\t\022\020\n\010firmware\030\002 \002(\t\022\r\n\005build\030\003 \002(\t\022\022\n\nu" +
      "sually2_1\030\004 \002(\005\022\013\n\003idk\030\005 \002(\014\022\022\n\nusually2",
      "_2\030\006 \002(\005\022\020\n\010usually1\030\007 \002(\005\"\200\001\n\nDeviceInf" +
      "o\022\021\n\tshortName\030\001 \002(\t\022\020\n\010realName\030\002 \002(\t\022\016" +
      "\n\006serial\030\003 \002(\t\022\r\n\005color\030\004 \002(\t\022\r\n\005model\030\005" +
      " \002(\t\022\022\n\nprettyName\030\006 \002(\t\022\013\n\003idk\030\007 \001(\t\"\034\n" +
      "\004Keys\022\024\n\006keySet\030\001 \003(\0132\004.Key\"\"\n\003Key\022\r\n\005in" +
      "dex\030\001 \002(\005\022\014\n\004data\030\002 \002(\t"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_DeviceUdids_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_DeviceUdids_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_DeviceUdids_descriptor,
              new java.lang.String[] { "Psid", "Udids", "UsuallyFalse", });
          internal_static_Device_descriptor =
            getDescriptor().getMessageTypes().get(1);
          internal_static_Device_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_Device_descriptor,
              new java.lang.String[] { "Udid", "FullSize", "Backup", "Device", "Time", });
          internal_static_Backup_descriptor =
            getDescriptor().getMessageTypes().get(2);
          internal_static_Backup_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_Backup_descriptor,
              new java.lang.String[] { "SnapshotID", "Size", "Time1", "Info", "Time2", });
          internal_static_BackupInfo_descriptor =
            getDescriptor().getMessageTypes().get(3);
          internal_static_BackupInfo_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_BackupInfo_descriptor,
              new java.lang.String[] { "Name", "Firmware", "Build", "Usually21", "Idk", "Usually22", "Usually1", });
          internal_static_DeviceInfo_descriptor =
            getDescriptor().getMessageTypes().get(4);
          internal_static_DeviceInfo_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_DeviceInfo_descriptor,
              new java.lang.String[] { "ShortName", "RealName", "Serial", "Color", "Model", "PrettyName", "Idk", });
          internal_static_Keys_descriptor =
            getDescriptor().getMessageTypes().get(5);
          internal_static_Keys_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_Keys_descriptor,
              new java.lang.String[] { "KeySet", });
          internal_static_Key_descriptor =
            getDescriptor().getMessageTypes().get(6);
          internal_static_Key_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_Key_descriptor,
              new java.lang.String[] { "Index", "Data", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
