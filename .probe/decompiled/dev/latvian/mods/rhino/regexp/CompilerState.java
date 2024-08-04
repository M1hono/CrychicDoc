package dev.latvian.mods.rhino.regexp;

import dev.latvian.mods.rhino.Context;

class CompilerState {

    Context cx;

    char[] cpbegin;

    int cpend;

    int cp;

    int flags;

    int backReferenceLimit;

    int maxBackReference;

    int parenCount;

    int parenNesting;

    int classCount;

    int progLength;

    RENode result;

    CompilerState(Context cx, char[] source, int length, int flags) {
        this.cx = cx;
        this.cpbegin = source;
        this.cp = 0;
        this.cpend = length;
        this.flags = flags;
        this.backReferenceLimit = Integer.MAX_VALUE;
        this.maxBackReference = 0;
        this.parenCount = 0;
        this.classCount = 0;
        this.progLength = 0;
    }
}