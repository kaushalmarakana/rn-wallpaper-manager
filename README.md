# rn-wallpaper-manager
1. A library for set wallpaper as Home Screen wallpaper
2. Currently Only Supports on ANDROID Platform

## Getting started

`$ npm install rn-wallpaper-manager --save`

### Mostly automatic installation

#react-native < 0.60
`$ react-native link rn-wallpaper-manager`

### Manual installation

<!-- #### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `rn-wallpaper-manager` and add `RNWallPaperManager.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNWallPaperManager.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`) -->

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNWallPaperManagerPackage;` to the imports at the top of the file
  - Add `new RNWallPaperManagerPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':rn-wallpaper-manager'
  	project(':rn-wallpaper-manager').projectDir = new File(rootProject.projectDir, '../node_modules/rn-wallpaper-manager/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      implementation project(':rn-wallpaper-manager')
  	```

## Usage
```javascript
import RNWallPaperManager from 'rn-wallpaper-manager';

// TODO: What to do with the module?
try{
  await RNWallPaperManager.setAsWallpaper(Url);
} catch(err) {
  // handle error here
}
```