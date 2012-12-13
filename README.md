Activated State Demo
===================

The Situation
-----------
Android supports the mechanism of [State Lists][1] which help the developer when
styling elements under different conditions. For example, these ''State Lists''
can be used to apply a different style to focused (so hovering with your finger)
list items. 

When introducing the new [Fragment based interface][2] on Honeycomb (Android
3.0), a typical user interface (at least on tablets) looks like this:

    ![Android Facet Based Layout](https://raw.github.com/theomega/ActivatedStateDemo/master/screenshot.png)

There is a `Listview` on the left side where the user can select some kind of
''objects''. When selecting one of these objects, the right side of the screen
displays detailed information on this object. This workflow can be found on many
stock Android apps (People, Mail). These layouts and workflows can easily be
ported back to previous Android versions using the [support library][3] which
provides the `Fragement` and other classes to older Android versions.

Using these interfaces it is important to give the user a hint which item he
selected in the `ListView`. Android suggests to use the new `state_activated` on
the state list for the list items. Using a different style here, the item, the
user selected most recently can be styled differently.

The Problem
-----------
The `state_activated` and other related `activated` functionality is completly
missing in Android Versions before Honeycomb. Using the `state_activated`
selector in a state list simply fails silently. This means that although you can
use the fragments on older versions, the graphical hint for the user which item
he selected is missing.

The Solution
------------
Although there are various other solutions, I add present another one which has
the following features and unique properties:

  1. No need to modify your adapters.
  2. No need for caring which item was selected
  3. Most important: Full support of state lists, the means you can use the
     existing tools and constructs for styling your elements.
  4. Support even for colors of child elements
  5. Works on all Android versions

The trick is to ''missuse'' another state which Android supports since Version
1: `state_checked`. This state is typically used for check-boxes and other
things which can be visually checked. This approach reused the checked state but
hides the checkmarks. As all layout objects can be styled depending on their
checked state, state lists can be resused.

How To Use
----------

  1. Set the correct `choice mode` for the `ListView`:

    getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

  2. Adapt your item layout (so the layout of a single item in your `ListView`):
    
    - _If you only have a single `TextView` (as root) in your item layout:_
      Replace the `TextView` with a `CheckedTextView`. To remove the checkmark,
      add the attribute `android:checkMark="@null"` to the `CheckedTextView`.
    - _If you have a `LinearLayout` as root and you only need to change the
      background of the whole `LinearLayout` for the activated state:_ Replace
      the `LinearLayout` with the `CheckedLinearLayout` from the [source of this
      repository][5].
    - _If you have a `LinearLayout` as root and you also need to change the
      appearance of the children, for example to change the text color of a
      `TextView` in the `LinearLayout`:_ Replace the `LinearLayout` with the
      `CheckedLinearLayout` as above. Also replace the `TextViews` with the
      `CheckedTextViews` as explained above.

  3. Update your selector: Replace `android:state_activated` with
     `android:state_checked` for every selector. You can use all other features.
     This is true for both, backgrounds (drawabled) and colors. 



   [1]: http://developer.android.com/guide/topics/resources/drawable-resource.html#StateList
   [2]: http://developer.android.com/guide/components/fragments.html
   [3]: http://developer.android.com/tools/extras/support-library.html
   [5]: https://github.com/theomega/ActivatedStateDemo/blob/master/src/de/dbruhn/android/activatedstatedemo/CheckedLinearLayout.java
