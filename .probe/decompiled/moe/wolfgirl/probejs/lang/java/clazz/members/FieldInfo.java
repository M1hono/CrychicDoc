package moe.wolfgirl.probejs.lang.java.clazz.members;

import dev.latvian.mods.rhino.JavaMembers;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import moe.wolfgirl.probejs.lang.java.base.AnnotationHolder;
import moe.wolfgirl.probejs.lang.java.base.ClassPathProvider;
import moe.wolfgirl.probejs.lang.java.clazz.ClassPath;
import moe.wolfgirl.probejs.lang.java.type.TypeAdapter;
import moe.wolfgirl.probejs.lang.java.type.TypeDescriptor;

public class FieldInfo extends AnnotationHolder implements ClassPathProvider {

    public final String name;

    public final TypeDescriptor type;

    public final FieldInfo.FieldAttributes attributes;

    public FieldInfo(JavaMembers.FieldInfo field) {
        super(field.field.getAnnotations());
        this.name = field.name;
        this.type = TypeAdapter.getTypeDescription(field.field.getAnnotatedType());
        this.attributes = new FieldInfo.FieldAttributes(field.field);
    }

    @Override
    public Collection<ClassPath> getClassPaths() {
        return this.type.getClassPaths();
    }

    public static class FieldAttributes {

        public final boolean isFinal;

        public final boolean isStatic;

        private final Field field;

        public FieldAttributes(Field field) {
            int modifiers = field.getModifiers();
            this.isFinal = Modifier.isFinal(modifiers);
            this.isStatic = Modifier.isStatic(modifiers);
            this.field = field;
        }

        public Object getStaticValue() throws IllegalAccessException {
            if (this.isStatic) {
                throw new RuntimeException("The field is not static!");
            } else {
                return this.field.get(null);
            }
        }
    }
}