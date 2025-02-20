/*
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2 of the license or (at your option) any later version.
*/

package org.gjt.jclasslib.bytecode

import org.gjt.jclasslib.structures.ClassFileEnum
import org.gjt.jclasslib.structures.Lookup
import kotlin.enums.enumEntries

/**
 * Defines all opcodes and their verbose representation.
 * @property verbose Verbose representation.
 */
@Suppress("NOT_DOCUMENTED")
enum class Opcode(override val tag: Int, val verbose: String, private val docAnchorSuffix: String = verbose) : ClassFileEnum {
    NOP(0, "nop"),
    ACONST_NULL(1, "aconst_null"),
    ICONST_M1(2, "iconst_m1", "iconst_i"),
    ICONST_0(3, "iconst_0", "iconst_i"),
    ICONST_1(4, "iconst_1", "iconst_i"),
    ICONST_2(5, "iconst_2", "iconst_i"),
    ICONST_3(6, "iconst_3", "iconst_i"),
    ICONST_4(7, "iconst_4", "iconst_i"),
    ICONST_5(8, "iconst_5", "iconst_i"),
    LCONST_0(9, "lconst_0", "lconst_l"),
    LCONST_1(10, "lconst_1", "lconst_l"),
    FCONST_0(11, "fconst_0", "fconst_f"),
    FCONST_1(12, "fconst_1", "fconst_f"),
    FCONST_2(13, "fconst_2", "fconst_f"),
    DCONST_0(14, "dconst_0", "dconst_d"),
    DCONST_1(15, "dconst_1", "dconst_d"),
    BIPUSH(16, "bipush"),
    SIPUSH(17, "sipush"),
    LDC(18, "ldc"),
    LDC_W(19, "ldc_w"),
    LDC2_W(20, "ldc2_w"),
    ILOAD(21, "iload"),
    LLOAD(22, "lload"),
    FLOAD(23, "fload"),
    DLOAD(24, "dload"),
    ALOAD(25, "aload"),
    ILOAD_0(26, "iload_0", "iload_n"),
    ILOAD_1(27, "iload_1", "iload_n"),
    ILOAD_2(28, "iload_2", "iload_n"),
    ILOAD_3(29, "iload_3", "iload_n"),
    LLOAD_0(30, "lload_0", "lload_n"),
    LLOAD_1(31, "lload_1", "lload_n"),
    LLOAD_2(32, "lload_2", "lload_n"),
    LLOAD_3(33, "lload_3", "lload_n"),
    FLOAD_0(34, "fload_0", "fload_n"),
    FLOAD_1(35, "fload_1", "fload_n"),
    FLOAD_2(36, "fload_2", "fload_n"),
    FLOAD_3(37, "fload_3", "fload_n"),
    DLOAD_0(38, "dload_0", "dload_n"),
    DLOAD_1(39, "dload_1", "dload_n"),
    DLOAD_2(40, "dload_2", "dload_n"),
    DLOAD_3(41, "dload_3", "dload_n"),
    ALOAD_0(42, "aload_0", "aload_n"),
    ALOAD_1(43, "aload_1", "aload_n"),
    ALOAD_2(44, "aload_2", "aload_n"),
    ALOAD_3(45, "aload_3", "aload_n"),
    IALOAD(46, "iaload"),
    LALOAD(47, "laload"),
    FALOAD(48, "faload"),
    DALOAD(49, "daload"),
    AALOAD(50, "aaload"),
    BALOAD(51, "baload"),
    CALOAD(52, "caload"),
    SALOAD(53, "saload"),
    ISTORE(54, "istore"),
    LSTORE(55, "lstore"),
    FSTORE(56, "fstore"),
    DSTORE(57, "dstore"),
    ASTORE(58, "astore"),
    ISTORE_0(59, "istore_0", "istore_n"),
    ISTORE_1(60, "istore_1", "istore_n"),
    ISTORE_2(61, "istore_2", "istore_n"),
    ISTORE_3(62, "istore_3", "istore_n"),
    LSTORE_0(63, "lstore_0", "lstore_n"),
    LSTORE_1(64, "lstore_1", "lstore_n"),
    LSTORE_2(65, "lstore_2", "lstore_n"),
    LSTORE_3(66, "lstore_3", "lstore_n"),
    FSTORE_0(67, "fstore_0", "fstore_n"),
    FSTORE_1(68, "fstore_1", "fstore_n"),
    FSTORE_2(69, "fstore_2", "fstore_n"),
    FSTORE_3(70, "fstore_3", "fstore_n"),
    DSTORE_0(71, "dstore_0", "dstore_n"),
    DSTORE_1(72, "dstore_1", "dstore_n"),
    DSTORE_2(73, "dstore_2", "dstore_n"),
    DSTORE_3(74, "dstore_3", "dstore_n"),
    ASTORE_0(75, "astore_0", "astore_n"),
    ASTORE_1(76, "astore_1", "astore_n"),
    ASTORE_2(77, "astore_2", "astore_n"),
    ASTORE_3(78, "astore_3", "astore_n"),
    IASTORE(79, "iastore"),
    LASTORE(80, "lastore"),
    FASTORE(81, "fastore"),
    DASTORE(82, "dastore"),
    AASTORE(83, "aastore"),
    BASTORE(84, "bastore"),
    CASTORE(85, "castore"),
    SASTORE(86, "sastore"),
    POP(87, "pop"),
    POP2(88, "pop2"),
    DUP(89, "dup"),
    DUP_X1(90, "dup_x1"),
    DUP_X2(91, "dup_x2"),
    DUP2(92, "dup2"),
    DUP2_X1(93, "dup2_x1"),
    DUP2_X2(94, "dup2_x2"),
    SWAP(95, "swap"),
    IADD(96, "iadd"),
    LADD(97, "ladd"),
    FADD(98, "fadd"),
    DADD(99, "dadd"),
    ISUB(100, "isub"),
    LSUB(101, "lsub"),
    FSUB(102, "fsub"),
    DSUB(103, "dsub"),
    IMUL(104, "imul"),
    LMUL(105, "lmul"),
    FMUL(106, "fmul"),
    DMUL(107, "dmul"),
    IDIV(108, "idiv"),
    LDIV(109, "ldiv"),
    FDIV(110, "fdiv"),
    DDIV(111, "ddiv"),
    IREM(112, "irem"),
    LREM(113, "lrem"),
    FREM(114, "frem"),
    DREM(115, "drem"),
    INEG(116, "ineg"),
    LNEG(117, "lneg"),
    FNEG(118, "fneg"),
    DNEG(119, "dneg"),
    ISHL(120, "ishl"),
    LSHL(121, "lshl"),
    ISHR(122, "ishr"),
    LSHR(123, "lshr"),
    IUSHR(124, "iushr"),
    LUSHR(125, "lushr"),
    IAND(126, "iand"),
    LAND(127, "land"),
    IOR(128, "ior"),
    LOR(129, "lor"),
    IXOR(130, "ixor"),
    LXOR(131, "lxor"),
    IINC(132, "iinc"),
    I2L(133, "i2l"),
    I2F(134, "i2f"),
    I2D(135, "i2d"),
    L2I(136, "l2i"),
    L2F(137, "l2f"),
    L2D(138, "l2d"),
    F2I(139, "f2i"),
    F2L(140, "f2l"),
    F2D(141, "f2d"),
    D2I(142, "d2i"),
    D2L(143, "d2l"),
    D2F(144, "d2f"),
    I2B(145, "i2b"),
    I2C(146, "i2c"),
    I2S(147, "i2s"),
    LCMP(148, "lcmp"),
    FCMPL(149, "fcmpl", "fcmp_op"),
    FCMPG(150, "fcmpg", "fcmp_op"),
    DCMPL(151, "dcmpl", "dcmp_op"),
    DCMPG(152, "dcmpg", "dcmp_op"),
    IFEQ(153, "ifeq", "if_cond"),
    IFNE(154, "ifne", "if_cond"),
    IFLT(155, "iflt", "if_cond"),
    IFGE(156, "ifge", "if_cond"),
    IFGT(157, "ifgt", "if_cond"),
    IFLE(158, "ifle", "if_cond"),
    IF_ICMPEQ(159, "if_icmpeq", "if_icmp_cond"),
    IF_ICMPNE(160, "if_icmpne", "if_acmp_cond"),
    IF_ICMPLT(161, "if_icmplt", "if_acmp_cond"),
    IF_ICMPGE(162, "if_icmpge", "if_acmp_cond"),
    IF_ICMPGT(163, "if_icmpgt", "if_acmp_cond"),
    IF_ICMPLE(164, "if_icmple", "if_acmp_cond"),
    IF_ACMPEQ(165, "if_acmpeq", "if_acmp_cond"),
    IF_ACMPNE(166, "if_acmpne", "if_acmp_cond"),
    GOTO(167, "goto"),
    JSR(168, "jsr"),
    RET(169, "ret"),
    TABLESWITCH(170, "tableswitch"),
    LOOKUPSWITCH(171, "lookupswitch"),
    IRETURN(172, "ireturn"),
    LRETURN(173, "lreturn"),
    FRETURN(174, "freturn"),
    DRETURN(175, "dreturn"),
    ARETURN(176, "areturn"),
    RETURN(177, "return"),
    GETSTATIC(178, "getstatic"),
    PUTSTATIC(179, "putstatic"),
    GETFIELD(180, "getfield"),
    PUTFIELD(181, "putfield"),
    INVOKEVIRTUAL(182, "invokevirtual"),
    INVOKESPECIAL(183, "invokespecial"),
    INVOKESTATIC(184, "invokestatic"),
    INVOKEINTERFACE(185, "invokeinterface"),
    INVOKEDYNAMIC(186, "invokedynamic"),
    NEW(187, "new"),
    NEWARRAY(188, "newarray"),
    ANEWARRAY(189, "anewarray"),
    ARRAYLENGTH(190, "arraylength"),
    ATHROW(191, "athrow"),
    CHECKCAST(192, "checkcast"),
    INSTANCEOF(193, "instanceof"),
    MONITORENTER(194, "monitorenter"),
    MONITOREXIT(195, "monitorexit"),
    WIDE(196, "wide"),
    MULTIANEWARRAY(197, "multianewarray"),
    IFNULL(198, "ifnull"),
    IFNONNULL(199, "ifnonnull"),
    GOTO_W(200, "goto_w"),
    JSR_W(201, "jsr_w"),
    BREAKPOINT(202, "breakpoint", ""),
    IMPDEP1(254, "impdep1", ""),
    IMPDEP2(255, "impdep2", "");

    /**
     * The URL to the documentation in the JVM spec
     */
    val docUrl: String
        get() = "https://docs.oracle.com/javase/specs/jvms/se19/html/jvms-6.html#jvms-6.5.$docAnchorSuffix"

    override fun toString() = verbose

    companion object : Lookup<Opcode>(enumEntries<Opcode>(), "opcode")
}
