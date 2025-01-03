package Chapter_1_CreateAndDestroyObject;

/*
Finalizers are unpredictable, often dangerous, and generally unnecessary.
Their use can cause erratic behavior, poor performance, and portability
problems. Finalizers have a few valid uses, which we’ll cover later in this item,
but as a rule, you should avoid them. As of Java 9, finalizers have been
deprecated, but they are still being used by the Java libraries. The Java 9
replacement for finalizers is cleaners. Cleaners are less dangerous than
finalizers, but still unpredictable, slow, and generally u

Finalizers have a serious security problem: they open your class up to
finalizer attacks.

 */
public class Item_8_AvoidFinalizersAndCleaners {
}
