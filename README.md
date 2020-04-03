# AndroidxLazyLoad
 
 AndroidxLazyLoad 是 Androidx 模式下 Fragment 懒加载的新实现，通过使用 `FragmentTransaction.setMaxLifecycle()` 方法来控制 Fragment 可调用的最大生命周期函数。
 
该项目中包含以下Fragment的使用场景

- ViewPager + FragmentPagerAdapter
- ViewPager + FragmentStatePagerAdapter
- Activity + Fragment
- Fragment + Fragment(嵌套模式）
- 复杂 Fragment 嵌套 （上述4种场景的各种组合)
-  ViewPager2 + Fragment

## 如何使用？

使用该方案，你需要进行如下三步修改。

### 修改你的 ViewPager 适配器

在你的 ViewPager 适配器中增加如下参数：

```kotin
FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) 

FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
```

### 修改你的 add+show+hide 方法

- 将需要显示的 Fragment ，在调用 add 或 show 方法后，`setMaxLifecycle(showFragment, Lifecycle.State.RESUMED)`
- 将需要隐藏的 Fragment ，在调用 hide 方法后，`setMaxLifecycle(fragment, Lifecycle.State.STARTED)`

如下所示：

```kotlin
/**
 * 使用add+show+hide模式加载fragment
 *
 * 默认显示位置[showPosition]的Fragment，最大Lifecycle为Lifecycle.State.RESUMED
 * 其他隐藏的Fragment，最大Lifecycle为Lifecycle.State.STARTED
 *
 *@param containerViewId 容器id
 *@param showPosition  fragments
 *@param fragmentManager FragmentManager
 *@param fragments  控制显示的Fragments
 */
private fun loadFragmentsTransaction(
    @IdRes containerViewId: Int,
    showPosition: Int,
    fragmentManager: FragmentManager,
    vararg fragments: Fragment
) {
    if (fragments.isNotEmpty()) {
        fragmentManager.beginTransaction().apply {
            for (index in fragments.indices) {
                val fragment = fragments[index]
                add(containerViewId, fragment, fragment.javaClass.name)
                if (showPosition == index) {
                    setMaxLifecycle(fragment, Lifecycle.State.RESUMED)
                } else {
                    hide(fragment)
                    setMaxLifecycle(fragment, Lifecycle.State.STARTED)
                }
            }

        }.commit()
    } else {
        throw IllegalStateException(
            "fragments must not empty"
        )
    }
}

/** 显示需要显示的Fragment[showFragment]，并设置其最大Lifecycle为Lifecycle.State.RESUMED。
 *  同时隐藏其他Fragment,并设置最大Lifecycle为Lifecycle.State.STARTED
 * @param fragmentManager
 * @param showFragment
 */
private fun showHideFragmentTransaction(fragmentManager: FragmentManager, showFragment: Fragment) {
    fragmentManager.beginTransaction().apply {
        show(showFragment)
        setMaxLifecycle(showFragment, Lifecycle.State.RESUMED)

        //获取其中所有的fragment,其他的fragment进行隐藏
        val fragments = fragmentManager.fragments
        for (fragment in fragments) {
            if (fragment != showFragment) {
                hide(fragment)
                setMaxLifecycle(fragment, Lifecycle.State.STARTED)
            }
        }
    }.commit()
}
```

完整代码请点击--->[ShowHideExt](https://github.com/AndyJennifer/AndroidxLazyLoad/blob/master/app/src/main/java/com/jennifer/andy/androidxlazyload/ext/ShowHideExt.kt)

### 创建你的懒加载Fragment

```kotlin
abstract class LazyFragment : LogFragment() {

    private var isLoaded = false

    override fun onResume() {
        super.onResume()
        if (!isLoaded && !isHidden) {
            lazyInit()
            Log.d(TAG, "lazyInit:!!!!!!!")
            isLoaded = true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isLoaded = false
    }

    abstract fun lazyInit()
}
```

## 使用该方案的优缺点

- 优点：`在非特殊的情况下(缺点1)`，只有实际的可见 Fragment，其 `onResume` 方法才会被调用，这样才符合方法设计的初衷。
- 缺点：
  1. 对于 Fragment 的嵌套，及时使用了 `setMaxLifecycle` 方法。同级不可见的Fragment， 仍然要调用 `onResume` 方法。
  2. 需要在原有的 add+show+hide 方法中，继续调用 setMaxLifecycle 方法来控制Fragment 的最大生命状态。

## 更多 👏

如果你想了解其中的原理，你可以阅读该文章:

- [Androidx下Fragment的懒加载](https://andyjennifer.com/2020/01/19/Androidx下Fragment的懒加载/)

## 最后

如果你觉得项目不错，欢迎点击 star ❤️或 follow，也可以帮忙分享给你更多的朋友。你的支持与鼓励是给我继续做好该项目的最大动力。

## 联系我

- QQ:443696320
- 简书：[AndyandJennifer](https://www.jianshu.com/users/921c778fb5e1/timeline)
- 掘金：[AndyandJennifer](https://juejin.im/user/5acc1ea06fb9a028bc2e0fc1)
- Email: [andyjennifer@126.com](andyjennifer@126.com)
