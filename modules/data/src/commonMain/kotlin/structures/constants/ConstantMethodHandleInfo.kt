/*
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2 of the license or (at your option) any later version.
*/

package org.gjt.jclasslib.structures.constants

import org.gjt.jclasslib.io.DataInput
import org.gjt.jclasslib.io.DataOutput
import org.gjt.jclasslib.structures.AbstractConstant
import org.gjt.jclasslib.structures.ClassFile
import org.gjt.jclasslib.structures.ConstantType

/**
 * Describes a CONSTANT_MethodHandle_info constant pool data structure.
 */
class ConstantMethodHandleInfo private constructor(classFile: ClassFile) : AbstractConstant(classFile) {

    /**
     * Constructor.
     * @param type the method handle type
     * @param classFile the class file of which this structure is part of
     */
    constructor(type: MethodHandleType, classFile: ClassFile) : this(classFile) {
        this.type = type
    }

    internal constructor(classFile: ClassFile, input: DataInput) : this(classFile) {
        read(input)
    }

    /**
     * Index of the constant pool entry containing the reference.
     */
    var referenceIndex: Int = 0

    /**
     * Method handle type.
     */
    lateinit var type: MethodHandleType

    override val constantType: ConstantType
        get() = ConstantType.METHOD_HANDLE

    override val verbose: String
        get() = name

    /**
     * Get the descriptor.
     * @return the descriptor
     */
    val name: String
        get() = constantType.verbose + " " + referenceConstant.verbose

    /**
     * Returns the ConstantReference constant pool entry that contains the reference
     */
    val referenceConstant: ConstantReference
        get() = classFile.getConstantPoolEntry(referenceIndex, ConstantReference::class)

    override fun readData(input: DataInput) {
        type = MethodHandleType.getFromTag(input.readUnsignedByte())
        referenceIndex = input.readUnsignedShort()
    }

    override fun writeData(output: DataOutput) {
        output.writeByte(ConstantType.METHOD_HANDLE.tag)
        output.writeByte(type.tag)
        output.writeShort(referenceIndex)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is ConstantMethodHandleInfo) {
            return false
        }
        return super.equals(other) && other.referenceIndex == referenceIndex && other.type == type
    }

    override fun hashCode(): Int = super.hashCode() xor referenceIndex

    override val debugInfo: String
        get() = "with referenceIndex $referenceIndex and type $type"
}
