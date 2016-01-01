/*
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2 of the license, or (at your option) any later version.
*/

package org.gjt.jclasslib.structures

import java.util.*

/**
 * Defines access flags constants and verbose expressions as defined by
 * the java access modifiers.

 * @author [Ingo Kegel](mailto:jclasslib@ej-technologies.com), [Vitor Carreira](mailto:vitor.carreira@gmail.com)
 */
enum class AccessFlag(
        /**
         * The flag
         */
        val flag: Int,
        /**
         * Verbose form of the flag suitable for printing a list of access flags
         */
        val verbose: String
) {

    PUBLIC(1, "public"),
    PRIVATE(2, "private"),
    PROTECTED(4, "protected"),
    STATIC(8, "static"),
    FINAL(16, "final"),
    SYNCHRONIZED(32, "synchronized"),
    /**
     * For ClassFile structures, 0x0020 is ACC_SUPER, which has historical significance only
     */
    SUPER(32, ""),
    VOLATILE(64, "volatile"),
    TRANSIENT(128, "transient"),

    NATIVE(256, "native"),
    INTERFACE(512, "interface"),
    ABSTRACT(1024, "abstract"),
    STRICT(2048, "strict"),

    /**
     * new in Java 1.4
     */
    SYNTHETIC(4096, "synthetic"),
    /**
     * new in Java 1.5
     */
    ANNOTATION(8192, "annotation"),
    /**
     * new in Java 1.5
     */
    ENUM(16384, "enum"),
    /**
     * new in Java 1.5
     */
    BRIDGE(64, "bridge"),
    /**
     * new in Java 1.5
     */
    VARARGS(128, "varargs");

    /** Checks if this access flag is set in the supplied access flags.
     * @param accessFlags the access flags
     */
    fun isSet(accessFlags: Int): Boolean {
        return accessFlags and flag == flag
    }

    companion object {

        /**
         * Class access flags
         */
        val CLASS_ACCESS_FLAGS = EnumSet.of(
                PUBLIC,
                FINAL,
                SUPER,
                INTERFACE,
                ABSTRACT,
                SYNTHETIC,
                ANNOTATION,
                ENUM)

        /**
         * Inner class access flags
         */
        val INNER_CLASS_ACCESS_FLAGS = EnumSet.of(
                PUBLIC,
                PRIVATE,
                PROTECTED,
                STATIC,
                FINAL,
                INTERFACE,
                ABSTRACT,
                SYNTHETIC,
                ANNOTATION,
                ENUM)

        /**
         * Field access flags
         */
        val FIELD_ACCESS_FLAGS = EnumSet.of(
                PUBLIC,
                PRIVATE,
                PROTECTED,
                STATIC,
                FINAL,
                VOLATILE,
                TRANSIENT,
                SYNTHETIC,
                ENUM)

        /**
         * Method access flags
         */
        val METHOD_ACCESS_FLAGS = EnumSet.of(
                PUBLIC,
                PRIVATE,
                PROTECTED,
                STATIC,
                FINAL,
                SYNCHRONIZED,
                BRIDGE,
                VARARGS,
                NATIVE,
                ABSTRACT,
                STRICT,
                SYNTHETIC)
    }
}
