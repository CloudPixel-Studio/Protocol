package org.cloudburstmc.protocol.bedrock.data.defintions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cloudburstmc.nbt.NbtMap;

@Data
@EqualsAndHashCode(callSuper = true)
public class SimpleBlockDefinition extends BlockDefinition {
    private final String identifier;
    private final int runtimeId;
    private final NbtMap state;

    // Cache identifier as this implementation is immutable
    private transient String persistentIdentifier;

    @Override
    public String getPersistentIdentifier() {
        if (this.persistentIdentifier == null) {
            this.persistentIdentifier = super.getPersistentIdentifier();
        }
        return this.persistentIdentifier;
    }
}