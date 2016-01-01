/*
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2 of the license, or (at your option) any later version.
*/

package org.gjt.jclasslib.structures.attributes

import org.gjt.jclasslib.structures.AbstractStructure
import org.gjt.jclasslib.structures.ClassFile
import java.io.DataInput
import java.io.DataOutput

/**
 * Describes an exception table entry in a Code attribute structure.

 * @author [Ingo Kegel](mailto:jclasslib@ej-technologies.com), [Vitor Carreira](mailto:vitor.carreira@gmail.com)
 */
class ExceptionTableEntry : AbstractStructure() {

    /**
     * start_pc of this exception table entry.
     */
    var startPc: Int = 0

    /**
     * end_pc of this exception table entry.
     */
    var endPc: Int = 0

    /**
     * handler_pc of this exception table entry.
     */
    var handlerPc: Int = 0

    /**
     * Constant pool index for the catch type of this exception table entry.
     */
    var catchType: Int = 0


    override fun readData(input: DataInput) {
        startPc = input.readUnsignedShort()
        endPc = input.readUnsignedShort()
        handlerPc = input.readUnsignedShort()
        catchType = input.readUnsignedShort()
    }

    override fun writeData(output: DataOutput) {
        output.writeShort(startPc)
        output.writeShort(endPc)
        output.writeShort(handlerPc)
        output.writeShort(catchType)
    }

    override val debugInfo: String
        get() = "with startPc $startPc, endPc $endPc, handlerPc $handlerPc, catchType $catchType"

    companion object {

        /**
         * Length in bytes of an exception table entry.
         */
        val LENGTH = 8

    }

}
