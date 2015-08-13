var gulp = require('gulp'),
	concat = require('gulp-concat'),
	changed = require('gulp-changed'),
	connect = require('gulp-connect'),
	historyApiFallback = require('connect-history-api-fallback'),
	typescript = require('gulp-tsc'),
	bowerSrc = require('gulp-bower-files'),
	sass = require('gulp-sass'),
	cssmin = require('gulp-cssmin'),
	importCss = require('gulp-import-css'),
	es = require('event-stream'),
	bourbon = require('node-bourbon').includePaths,
	RUN_SEQUENCE = require('run-sequence'),
	SOURCEMAPS = require("gulp-sourcemaps"),
	rename = require('gulp-rename'),
	iconfont = require('gulp-iconfont'),
	consolidate = require('gulp-consolidate'),
	autoprefixer = require('gulp-autoprefixer'),
	yuidoc = require("gulp-yuidoc"),

	env = process.env.NODE_ENV || 'dev';
var urlModule = require("url");
var http = require('http');
var querystring = require('querystring');
var fs = require('fs');
gulp.task('iconfont', function () {
	gulp.src(['../core/themes/icons/*.svg'])
		.pipe(iconfont({
			fontName: 'icons'
		}))
		.on('codepoints', function (codepoints, options) {
			gulp.src('../core/themes/scss/templates/_icons.scss')
				.pipe(consolidate('lodash', {
					glyphs: codepoints,
					fontName: 'icons',
					fontPath: '../fonts/icons/',
					className: 'icon',
					timeStamp: function () {
						return Date.now();
					}
				}))
				.pipe(gulp.dest('../core/themes/scss/'));
		})
		.pipe(gulp.dest('target/fonts/icons'));
});

gulp.task('autoprefixer', function () {
	gulp.src('target/css/app.css')
		.pipe(autoprefixer({
			browsers: ['ff>=24'],
			cascade: false
		}))
		.pipe(gulp.dest('target/css'));
});

gulp.task('copy', function () {
	return gulp.src(['!*.js', '../core/themes/assets/**'])
		.pipe(changed('target'))
		.pipe(gulp.dest('target'))
		.pipe(connect.reload());
});

gulp.task('copyIndex', function () {
	return gulp.src(['../index.html'])
		.pipe(gulp.dest('target'))
		.pipe(connect.reload());
});

gulp.task('templates', function () {
	console.log('templates');
	gulp.src('../core/**/*.html')
		.pipe(changed('target/core'))
		.pipe(gulp.dest('target/core'));

	gulp.src('../pages/**/*.html')
		.pipe(changed('target/pages'))
		.pipe(gulp.dest('target/pages'))
		.pipe(connect.reload());


});

gulp.task('first', function () {
	return gulp.src('../app.ts').pipe(gulp.dest('../'))
		.pipe(typescript({
			out:"app.js"
		}))
		.pipe(gulp.dest('target/js/'))
});

gulp.task('scripts.app', ['first'], function () {
	source = [
		'target/js/app.js'
	];

	gulp.src('../assets/**/*.*')
		.pipe(gulp.dest('target/assets'))
	gulp.src('../icons/**/*.*')
		.pipe(gulp.dest('target/icons'))
	gulp.src('../externals/**/*.*')
		.pipe(gulp.dest('target/externals'))

	return gulp.src(source)
		.pipe(concat('app.js'))
		.pipe(gulp.dest('target/js/'))
		.pipe(connect.reload());
});

gulp.task('scripts.vendor', function () {
	return bowerSrc()
		.pipe(concat('vendor.js'))
		.pipe(gulp.dest('target/js/'))
		.pipe(connect.reload());
});

gulp.task('sass', function () {
	gulp.src('../core/themes/scss/app.scss')
		.pipe(sass({
			//	errLogToConsole: true
		}))
		.pipe(importCss())
		.pipe(autoprefixer({
			browsers: ['Firefox >=24'],
			cascade: false
		}))
		.pipe(cssmin())
		.pipe(gulp.dest('target/css'))
		.pipe(connect.reload());
});

gulp.task('server', function () {

	var base = function (req, res, next) {
		req.url = req.url.replace('web-admin-llo/', '');
		next();
	}
	connect.server({
		root: 'target',
		port: 3333,
		livereload: true,
		middleware: function () {
			return [
				historyApiFallback,
				base
			]
		}
	});
});


gulp.task('config', function () {
	if (fs.existsSync("../config.api")) {
		return gulp.src('../config.api')
			.pipe(gulp.dest('target/config'));
	}
		
	return gulp.src('../core/themes/assets/json/config.api')
		.pipe(gulp.dest('target/config'))

});

gulp.task('doc', function () {
  gulp.src(['../core/**/*.ts'])
    .pipe(yuidoc())
    .pipe(gulp.dest("../target-doc"));
});

gulp.task('watch', function () {
    gulp.watch(['../core/themes/scss/*.scss', '../pages/**/*.scss', '../themes/**/*.scss'], {
        interval: 500
    }, ['sass']);
    gulp.watch(['../**/*.html'], {
        interval: 500
    }, ['templates']);
    gulp.watch(['../**/*.ts'], {
        interval: 500
    }, ['scripts.app']);


});

gulp.task('dev', ['copy', 'copyIndex'], function () {
	gulp.start( 'scripts.vendor', 'scripts.app', 'server', 'watch', 'config', 'iconfont', 'templates', 'sass');
});

gulp.task('build', ['copy', 'copyIndex'], function () {
	gulp.start('scripts.vendor', 'scripts.app', 'config', 'iconfont', 'templates', 'sass');
});
