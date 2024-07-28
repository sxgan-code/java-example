<script setup lang="ts">
const props = defineProps({
  fill: {type: String, default: '#FFFFFF', required: false},
  width: {type: String, default: '2rem', required: false},
  height: {type: String, default: '2rem', required: false},
})</script>
<template>
  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" version="1.1" viewBox="0 0 24 24">
    <defs>
      <filter id="uxs-a">
        <feColorMatrix in="SourceGraphic" type="matrix"
                       values="0 0 0 0 0.000000 0 0 0 0 0.000000 0 0 0 0 0.000000 0 0 0 1.000000 0"/>
      </filter>
    </defs>
    <g fill="none" fill-rule="evenodd" stroke="none" stroke-width="1" filter="url(#uxs-a)">
      <g fill-rule="nonzero" stroke="#5291FF" opacity=".9" transform="translate(2.25 2.5)">
        <path stroke-width="1.25"
              d="M4.66250543,12.8691999 C4.07900301,12.8691999 3.54933536,13.1005385 3.1658477,13.4754271 C2.78759501,13.8451982 2.55168792,14.3552571 2.55168792,14.9186717 C2.55168792,15.6378557 2.33556455,16.2460106 1.99728426,16.7397786 C1.81531944,17.005382 1.5970352,17.2377146 1.35644621,17.4353809 C2.02792598,17.8227141 2.80202421,18.0465988 3.56036734,18.0465988 C4.44788002,18.0465988 5.25303591,17.6944133 5.83602012,17.1243449 C6.41389601,16.5592716 6.77332298,15.7795181 6.77332298,14.9186717 C6.77342879,14.3551852 6.53759274,13.845168 6.15937088,13.4754271 C5.77587121,13.1005267 5.24612813,12.8691999 4.66250543,12.8691999 Z"/>
        <path stroke-width="1.5"
              d="M6.83523201,4.91375517 L19.4210544,4.91375517 C19.8352679,4.91375517 20.1710544,5.24954161 20.1710544,5.66375517 L20.1710544,7.22318346 C20.1710544,7.63739702 19.8352679,7.97318346 19.4210544,7.97318346 L6.83523201,7.97318346 C6.42101845,7.97318346 6.08523201,7.63739702 6.08523201,7.22318346 L6.08523201,5.66375517 C6.08523201,5.24954161 6.42101845,4.91375517 6.83523201,4.91375517 Z"
              transform="rotate(-45 13.128 6.443)"/>
      </g>
    </g>
  </svg>
</template>
<style scoped lang="scss">
svg {
  width: v-bind(width);
  height: v-bind(height);
}
</style>