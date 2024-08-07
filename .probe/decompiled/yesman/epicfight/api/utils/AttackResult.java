package yesman.epicfight.api.utils;

public class AttackResult {

    public final AttackResult.ResultType resultType;

    public final float damage;

    public AttackResult(AttackResult.ResultType resultType, float damage) {
        this.resultType = resultType;
        this.damage = damage;
    }

    public static AttackResult success(float damage) {
        return new AttackResult(AttackResult.ResultType.SUCCESS, damage);
    }

    public static AttackResult blocked(float damage) {
        return new AttackResult(AttackResult.ResultType.BLOCKED, damage);
    }

    public static AttackResult missed(float damage) {
        return new AttackResult(AttackResult.ResultType.MISSED, damage);
    }

    public static AttackResult of(AttackResult.ResultType resultType, float damage) {
        return new AttackResult(resultType, damage);
    }

    public static enum ResultType {

        SUCCESS(true, true), MISSED(false, false), BLOCKED(false, true);

        boolean dealtDamage;

        boolean shouldCount;

        private ResultType(boolean dealtDamage, boolean countAsHitEntity) {
            this.dealtDamage = dealtDamage;
            this.shouldCount = countAsHitEntity;
        }

        public boolean dealtDamage() {
            return this.dealtDamage;
        }

        public boolean shouldCount() {
            return this.shouldCount;
        }
    }
}